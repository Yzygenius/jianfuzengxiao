package com.jianfuzengxiao.wx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bamboo.framework.common.encrypt.MD5;
import com.bamboo.framework.common.util.DateUtil;
import com.jianfuzengxiao.base.common.HttpClientUtlis;
import com.jianfuzengxiao.base.common.MD5Util;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.AdminInfo;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;
import com.jianfuzengxiao.pub.service.IAdminInfoService;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;

/**
 * 小程序登录
 */
@Controller
@RequestMapping(value="/wx/admin")
public class AdminWXController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AdminWXController.class);
	
	@Autowired
	private IAdminInfoService adminInfoService;
	
	@Autowired
	private IAduitDistributionService aduitDistributionService;
	
	@ResponseBody
	@RequestMapping(value="/getOpneid")
	public String getOpenid(AdminInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getJsCode()), RC.OTHER_TOKEN_TIMEOUT);
			String openid = getOpenid(model.getJsCode());
			if (StringUtils.isBlank(openid)) {
				return apiResult(RC.OTHER_TOKEN_TIMEOUT);
			}
			model.setWxOpenid(openid);
			return apiResult(RC.SUCCESS, model);
		} catch (Exception e) {
			return exceptionResult(logger, "登录错误", e);
		}
	}
	
	/**
	 *	 小程序登录校验
	 * @param wxOpenid
	 * @return
	 * 	code 9000 重新登陆， 1 通过	
	 */
	@ResponseBody
	@RequestMapping(value="/verifyLogin")
	public String verifyLogin(AdminInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getWxOpenid()), RC.OTHER_TOKEN_TIMEOUT);
			//System.out.println(model);
			
			AdminInfoMVO adminInfo = new AdminInfoMVO();
			adminInfo.setWxOpenid(model.getWxOpenid());
			adminInfo.setSts("A");
			List<AdminInfoMVO> alist = adminInfoService.queryList(adminInfo);
			if (alist.size() < 1) {//用户不存在，返回登录页
				return apiResult(RC.OTHER_TOKEN_TIMEOUT);
			}else {
				adminInfo = alist.get(0);
				if (!StringUtils.equals(adminInfo.getPassword(), adminInfo.getWxPassword())) {
					return apiResult(RC.OTHER_TOKEN_TIMEOUT);
				}
			}
			adminInfo = alist.get(0);
			//管辖房产数量
			AduitDistributionMVO aduitDistributionMVO = new AduitDistributionMVO();
			aduitDistributionMVO.setAdminId(adminInfo.getAdminId());
			aduitDistributionMVO.setSts("A");
			List<AduitDistributionMVO> adList = aduitDistributionService.queryList(aduitDistributionMVO);
			adminInfo.setManageHousesCount(String.valueOf(adList.size()));
			
			return apiResult(RC.SUCCESS, adminInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "登录错误", e);
		}
	}
	
	/**
	 * 	登录
	 * @param loginName 账号, password 密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/login")
	public String login(AdminInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getLoginName()), RC.LOGIN_USERNAME_PASSWORD_CANNOT_NULL);
			throwAppException(StringUtils.isBlank(model.getPassword()), RC.LOGIN_USERNAME_PASSWORD_CANNOT_NULL);
			AdminInfoMVO adminInfo = new AdminInfoMVO();
			adminInfo.setLoginName(model.getLoginName());
			adminInfo.setSts("A");
			List<AdminInfoMVO> alist = adminInfoService.queryList(adminInfo);
			throwAppException(alist.size() < 1, RC.LOGIN_USERNAME_PASSWORD_ERROR);
			adminInfo = alist.get(0);
			String password = MD5Util.MD5Encode(model.getPassword() + adminInfo.getSatl());
			throwAppException(!StringUtils.equals(adminInfo.getPassword(), password), RC.LOGIN_USERNAME_PASSWORD_ERROR);
			
			adminInfo.setWxPassword(password);
			adminInfoService.update(adminInfo);
			//管辖房产数量
			AduitDistributionMVO aduitDistributionMVO = new AduitDistributionMVO();
			aduitDistributionMVO.setAdminId(adminInfo.getAdminId());
			aduitDistributionMVO.setSts("A");
			List<AduitDistributionMVO> adList = aduitDistributionService.queryList(aduitDistributionMVO);
			adminInfo.setManageHousesCount(String.valueOf(adList.size()));
			return apiResult(RC.SUCCESS, adminInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "登录错误", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * wx授权
	 * </p>
	 * @param adminId 管理员ID, wxOpenid , wxName 微信昵称, wxPhoto 头像, 
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月2日 下午4:20:02
	 */
	@ResponseBody
	@RequestMapping(value="/wxAuthorization")
	public String wxAuthorization(AdminInfoMVO model){
		try{
			throwAppException(StringUtils.isBlank(model.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
		//	String openid = getOpenid(model.getJsCode());
		//	model.setWxOpenid(model.getWxOpenid());
			System.out.println("openid-----"+model.getWxOpenid());
			model.setIsWx(AdminInfo.is_wx_yes);
			model.setWxTime(DateUtil.nowTime());
			adminInfoService.update(model);
			return apiResult(RC.SUCCESS, model);
		} catch (Exception e) {
			return exceptionResult(logger, "授权失败", e);
		}
	}
	
	/**
	 * 	解除微信 
	 * @param adminId 管理员ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/releaseWx")
	public String releaseWx(AdminInfoMVO model) {
		try {
			throwAppException(StringUtils.isBlank(model.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			model.setWxPassword("");
			model.setIsWx(AdminInfo.is_wx_no);
			model.setWxOpenid("");
			adminInfoService.update(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "解除微信失败", e);
		}
	}
	
	public String getOpenid(String jsCode){
		Map<String, Object> map = HttpClientUtlis.doGet("https://api.weixin.qq.com/sns/jscode2session?appid=wxe5f125ef95b24fb6&secret=47635568b0640d4e69632eb2677e2157&js_code="+jsCode+"&grant_type=authorization_code");
		/*String openid = "";
		if (map.get("errcode").equals(0)) {
			openid = (String) map.get("openid");
		}*/
		return (String) map.get("openid");
	}
	

}
