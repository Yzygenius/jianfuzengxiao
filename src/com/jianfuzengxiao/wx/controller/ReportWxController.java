package com.jianfuzengxiao.wx.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.base.utils.BigDouble;
import com.jianfuzengxiao.pub.entity.AdminInfo;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.LiveType;
import com.jianfuzengxiao.pub.entity.LiveTypeMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfo;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;

/**
 * 上报申请
 */
@Controller
@RequestMapping(value="/wx/report")
public class ReportWxController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(ReportWxController.class);
	
	@Autowired
	private IAduitDistributionService aduitDistributionService;
	
	@Autowired
	private IPersonnelInfoService personnelInfoService;
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 上报申请汇总
	 * </p>
	 * @param adminId 管理员ID
	 * @return  fz 房主、 zh 租户、 jsh 家属、 yg 员工 、 clv 处理率 ,  count 总数量、 auditCount 已审核数量、 waitAuditCount 待审核数量
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 下午12:08:55
	 */
	@ResponseBody
	@RequestMapping(value="/getReportCount")
	public String getReportCount(AduitDistributionMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			model.setSts("A");
			List<AduitDistributionMVO> aduitDistributionMVOs = aduitDistributionService.queryList(model);
			throwAppException(aduitDistributionMVOs.size() < 1, RC.HOUSES_INFO_REPORT_NULL);
			
			List<String> sList = new ArrayList<String>();
			for(AduitDistributionMVO ab : aduitDistributionMVOs){
				sList.add(ab.getHousesId());
			}
			String housesId = String.join(",", sList);
			Map<String, Object> map = new HashMap<String, Object>();
			//房主、店主
			JSONObject jsonObject1 = new JSONObject();
			PersonnelInfoMVO per1 = new PersonnelInfoMVO();
			per1.setSts("A");
			per1.setHousesId(housesId);
			per1.setLiveTypeId(LiveType.fangzhu_chanquanren + "," + LiveType.dianzhu_chanquanren + "," + LiveType.fangzhu_zulin + "," + LiveType.dianzhu_zulin);
			List<PersonnelInfoMVO> fzlist1 = personnelInfoService.queryPerList(per1);//房主、店主总数量
			per1.setStatus(PersonnelInfo.status_passed + "," + PersonnelInfo.status_reject);
			List<PersonnelInfoMVO> fzlist2 = personnelInfoService.queryPerList(per1);//房主、店主已审核数量
			per1.setStatus(PersonnelInfo.status_waiting);
			List<PersonnelInfoMVO> fzlist3 = personnelInfoService.queryPerList(per1);//房主、店主待审核数量
			jsonObject1.put("count", fzlist1.size());
			jsonObject1.put("auditCount", fzlist2.size());
			jsonObject1.put("waitAuditCount", fzlist3.size());
			map.put("fz", jsonObject1);
			
			//租户
			JSONObject jsonObject2 = new JSONObject();
			PersonnelInfoMVO per2 = new PersonnelInfoMVO();
			per2.setSts("A");
			per2.setHousesId(housesId);
			per2.setLiveTypeId(LiveType.zuhu);
			List<PersonnelInfoMVO> zhlist1 = personnelInfoService.queryPerList(per2);//租户总数量
			per2.setStatus(PersonnelInfo.status_passed + "," + PersonnelInfo.status_reject);
			List<PersonnelInfoMVO> zhlist2 = personnelInfoService.queryPerList(per2);//租户已审核数量
			per2.setStatus(PersonnelInfo.status_waiting);
			List<PersonnelInfoMVO> zhlist3 = personnelInfoService.queryPerList(per2);//租户待审核数量
			jsonObject2.put("count", zhlist1.size());
			jsonObject2.put("auditCount", zhlist2.size());
			jsonObject2.put("waitAuditCount", zhlist3.size());
			map.put("zh", jsonObject2);
			
			//家属
			JSONObject jsonObject3 = new JSONObject();
			PersonnelInfoMVO per3 = new PersonnelInfoMVO();
			per3.setSts("A");
			per3.setHousesId(housesId);
			per3.setLiveTypeId(LiveType.jiashu);
			List<PersonnelInfoMVO> jshlist1 = personnelInfoService.queryPerList(per3);//家属总数量
			per3.setStatus(PersonnelInfo.status_passed + "," + PersonnelInfo.status_reject);
			List<PersonnelInfoMVO> jshlist2 = personnelInfoService.queryPerList(per3);//家属已审核数量
			per3.setStatus(PersonnelInfo.status_waiting);
			List<PersonnelInfoMVO> jshlist3 = personnelInfoService.queryPerList(per3);//家属待审核数量
			jsonObject3.put("count", jshlist1.size());
			jsonObject3.put("auditCount", jshlist2.size());
			jsonObject3.put("waitAuditCount", jshlist3.size());
			map.put("jsh", jsonObject3);
			
			//员工
			JSONObject jsonObject4 = new JSONObject();
			PersonnelInfoMVO per4 = new PersonnelInfoMVO();
			per4.setSts("A");
			per4.setHousesId(housesId);
			per4.setLiveTypeId(LiveType.yuangong);
			List<PersonnelInfoMVO> yglist1 = personnelInfoService.queryPerList(per4);//员工总数量
			per4.setStatus(PersonnelInfo.status_passed + "," + PersonnelInfo.status_reject);
			List<PersonnelInfoMVO> yglist2 = personnelInfoService.queryPerList(per4);//员工已审核数量
			per4.setStatus(PersonnelInfo.status_waiting);
			List<PersonnelInfoMVO> yglist3 = personnelInfoService.queryPerList(per4);//员工待审核数量
			jsonObject4.put("count", yglist1.size());
			jsonObject4.put("auditCount", yglist2.size());
			jsonObject4.put("waitAuditCount", yglist3.size());
			map.put("yg", jsonObject4);
			
			//处理率
			double count = fzlist1.size() + zhlist1.size() + jshlist1.size() + yglist1.size();
			
			double aduitCount = fzlist2.size() + zhlist2.size() + jshlist2.size() + yglist2.size();
			double round = 0;
			if(round != 0 && aduitCount != 0){
				round = BigDouble.getRoundingCount(aduitCount / count);
			}
			
			map.put("clv", round);
			
			return apiResult(RC.SUCCESS, map);
		} catch (Exception e) {
			return exceptionResult(logger, "获取上报数量失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询上报申请列表 ，分页
	 * </p>
	 * @param admindId 管理员ID, liveTypeId 业主（1,2,3,4）、 家属（7）、租户（5）、员工（6） , status 待审核（1）、 已审核（2,3） 
	 * @return    
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月29日 下午2:21:50
	 */
	@ResponseBody
	@RequestMapping(value="/getReportPage")
	public String getReportPage(PersonnelInfoMVO model){
		try{
			throwAppException(StringUtils.isBlank(model.getAdminId()), RC.ADMIN_INFO_PARAM_ADMIN_ID_INVALID);
			AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
			aduitDistribution.setAdminId(model.getAdminId());
			aduitDistribution.setSts("A");
			List<AduitDistributionMVO> aduitDistributionMVOs = aduitDistributionService.queryList(aduitDistribution);
			throwAppException(aduitDistributionMVOs.size() < 1, RC.HOUSES_INFO_REPORT_NULL);
			
			List<String> sList = new ArrayList<String>();
			for(AduitDistributionMVO ab : aduitDistributionMVOs){
				sList.add(ab.getHousesId());
			}
			String housesId = String.join(",", sList);
			PageInfo pageInfo = getPage();
			model.setSts("A");
			model.setHousesId(housesId);
			pageInfo = personnelInfoService.queryHousesPage(model, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取上报房产列表失败", e);
		}
	}
}
