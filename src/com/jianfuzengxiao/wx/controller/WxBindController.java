package com.jianfuzengxiao.wx.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jianfuzengxiao.base.common.HttpClientUtlis;
import com.jianfuzengxiao.base.common.MD5Util;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.service.IAdminInfoService;

@Controller
@RequestMapping(value = "/wx/gzh")
public class WxBindController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(WxBindController.class);
	
	@Autowired
	private IAdminInfoService adminInfoService;
	
	@ResponseBody
	@RequestMapping(value = "/login")
	public void login() throws IOException {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc3cd63a0dedc396d&redirect_uri=http://pasq.niutuwangluo.com/jianfuzengxiao/wx/gzh/bind.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		response.sendRedirect(url);
	}
	
	@ResponseBody
	@RequestMapping(value = "/bind")
	public void bind() throws IOException {
		String code = request.getParameter("code");//获取微信服务器授权返回的code值
      
       // String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxc3cd63a0dedc396d&secret=fe938164018ad9edcc12f6c66fdcd132&code="+code+"&grant_type=authorization_code";                   
       // Map<String, Object> map = HttpClientUtlis.doGet(url);
       // String openid = map.get("openid").toString();
        
      //  logger.info("openid:"+openid);
        String url2 = "http://pasq.niutuwangluo.com/jianfuzengxiao/wx/gzh_bind.html?openid=12";
        response.sendRedirect(url2);
	}
	
	@ResponseBody
	@RequestMapping(value = "/verifyLogin")
	public String verifyLogin(AdminInfoMVO model){
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
			
			AdminInfoMVO ai = new AdminInfoMVO();
			ai.setAdminId(adminInfo.getAdminId());
			ai.setWxGzhOpenid(model.getWxGzhOpenid());
			adminInfoService.update(ai);
			
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "登录错误", e);
		}
	}
}
