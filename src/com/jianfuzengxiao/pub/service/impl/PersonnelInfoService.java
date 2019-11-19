package com.jianfuzengxiao.pub.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.api.controller.CertificatesTypeAPIController;
import com.jianfuzengxiao.base.common.HttpClientUtlis;
import com.jianfuzengxiao.base.common.PushUtils;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.wx.Send_template_message;
import com.jianfuzengxiao.pub.dao.IAdminInfoMDAO;
import com.jianfuzengxiao.pub.dao.IAduitDistributionMDAO;
import com.jianfuzengxiao.pub.dao.IHousesInfoMDAO;
import com.jianfuzengxiao.pub.dao.ILiveTypeMDAO;
import com.jianfuzengxiao.pub.dao.IMsgTypeMDAO;
import com.jianfuzengxiao.pub.dao.IPersonnelInfoMDAO;
import com.jianfuzengxiao.pub.dao.IUserInfoMDAO;
import com.jianfuzengxiao.pub.dao.impl.ContractFileMDAO;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.ContractFileMVO;
import com.jianfuzengxiao.pub.entity.HousesInfo;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.LiveType;
import com.jianfuzengxiao.pub.entity.LiveTypeMVO;
import com.jianfuzengxiao.pub.entity.MsgInfo;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
import com.jianfuzengxiao.pub.entity.MsgTypeMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfo;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IMsgInfoService;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;
import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

@Service
public class PersonnelInfoService extends BaseService implements IPersonnelInfoService {
	private static Logger logger = LoggerFactory.getLogger(PersonnelInfoService.class);
	
	@Autowired
	private IPersonnelInfoMDAO personnelInfoMDAO;
	
	@Autowired
	private IUserInfoMDAO userInfoMDAO;
	
	@Autowired
	private IMsgInfoService msgInfoService;
	
	@Autowired
	private IHousesInfoMDAO housesInfoMDAO;
	
	@Autowired
	private IMsgTypeMDAO msgTypeMDAO;
	
	@Autowired
	private ILiveTypeMDAO liveTypeMDAO;
	
	@Autowired
	private ContractFileMDAO contractFileMDAO;
	
	@Autowired
	private IAduitDistributionMDAO aduitDistributionMDAO;
	
	@Autowired
	private IAdminInfoMDAO adminInfoMDAO;

	/** 插入 */
	@Override
	public PersonnelInfoMVO insert(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
		personnelInfo.setCreateTime(DateUtil.nowTime());
		personnelInfo.setSts(STS_NORMAL);
		personnelInfo.setUpdateStatus(PersonnelInfo.update_status_one);
		return personnelInfoMDAO.insert(personnelInfo);
	}

	/** 更新 */
	@Override
	public int update(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
		personnelInfo.setUpdateTime(DateUtil.nowTime());
		return personnelInfoMDAO.update(personnelInfo);
	}

	/** 删除 */
	@Override
	public int delete(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
		return personnelInfoMDAO.delete(personnelInfo);
	}

	/** 查询集合列表 */
	@Override
	public List<PersonnelInfoMVO> queryList(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
		return personnelInfoMDAO.queryList(personnelInfo);
	}

	/** 查询对象 */
	@Override
	public PersonnelInfoMVO queryBean(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
		return personnelInfoMDAO.queryBean(personnelInfo);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(PersonnelInfoMVO personnelInfo, PageInfo pagInfo) throws SysException, AppException {
		return personnelInfoMDAO.queryPage(personnelInfo, pagInfo);
	}

	@Override
	public PageInfo queryHousesPage(PersonnelInfoMVO personnelInfo, PageInfo pageInfo) throws SysException {
		return personnelInfoMDAO.queryHousesPage(personnelInfo, pageInfo);
	}

	@Override
	public List<PersonnelInfoMVO> queryHousesList(PersonnelInfoMVO personnelInfo) throws SysException {
		return personnelInfoMDAO.queryHousesList(personnelInfo);
	}

	@Override
	public PersonnelInfoMVO queryPersonnelBean(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
		return personnelInfoMDAO.queryPersonnelBean(personnelInfo);
	}

	@Override
	public PersonnelInfoMVO addUserPersonnel(PersonnelInfoMVO model) throws SysException, AppException {
		UserInfoMVO userInfoMVO = new UserInfoMVO();
		userInfoMVO.setUserId(model.getUserId());
		userInfoMVO = userInfoMDAO.queryBean(userInfoMVO);
		
		PersonnelInfoMVO per = new PersonnelInfoMVO();
		per.setHousesId(model.getHousesId());
		per.setSts(STS_NORMAL);
//		per.setStatus("");
		per.setLiveTypeId("1,2,3,4");
		List<PersonnelInfoMVO> perList = personnelInfoMDAO.queryList(per);
		throwAppException(perList.size() > 0, RC.HOUSES_INFO_CERT_EXIST); 
		
		HousesInfoMVO housesInfo = new HousesInfoMVO();
		housesInfo.setHousesId(model.getHousesId());
		housesInfo = housesInfoMDAO.queryBean(housesInfo);
		
		//消息类型
		String type = "";
		
		LiveTypeMVO liveType = new LiveTypeMVO();
		//如果身份一致，则为自持房产
		if (StringUtils.equals(housesInfo.getPropertyOwnerIdcard(), userInfoMVO.getCertificatesNumber())) {
			//如果为房屋
			if (StringUtils.equals(housesInfo.getHousesStatus(), HousesInfo.houses_status_fangwu)) {
				liveType.setLiveTypeId(LiveType.fangzhu_chanquanren);
				liveType = liveTypeMDAO.queryBean(liveType);
				model.setLiveTypeId(LiveType.fangzhu_chanquanren);
				model.setLiveTypeName(liveType.getLiveTypeName());
				type = "z0101";
			}else if (StringUtils.equals(housesInfo.getHousesStatus(), HousesInfo.houses_status_dianpu)) {
				liveType.setLiveTypeId(LiveType.dianzhu_chanquanren);
				liveType = liveTypeMDAO.queryBean(liveType);
				model.setLiveTypeId(LiveType.dianzhu_chanquanren);
				model.setLiveTypeName(liveType.getLiveTypeName());
				type = "z0104";
			}
			model.setLeaseMode(PersonnelInfo.lease_mode_changqi);
			//model.setLeaseStartTime(userInfoMVO.getLeaseStartTime());
		}else {//否则为租赁房产
			//如果为房屋
			//throwAppException(StringUtils.isBlank(model.getLeaseContract()), RC.HOUSES_INFO_PARAM_CONTRACT_FILE_NULL); 
			if (StringUtils.equals(housesInfo.getHousesStatus(), HousesInfo.houses_status_fangwu)) {
				liveType.setLiveTypeId(LiveType.fangzhu_zulin);
				liveType = liveTypeMDAO.queryBean(liveType);
				model.setLiveTypeId(LiveType.fangzhu_zulin);
				model.setLiveTypeName(liveType.getLiveTypeName());
				type = "z0101";
			}else if (StringUtils.equals(housesInfo.getHousesStatus(), HousesInfo.houses_status_dianpu)) {
				liveType.setLiveTypeId(LiveType.dianzhu_zulin);
				liveType = liveTypeMDAO.queryBean(liveType);
				model.setLiveTypeId(LiveType.dianzhu_zulin);
				model.setLiveTypeName(liveType.getLiveTypeName());
				type = "z0104";
			}
			model.setLeaseMode(PersonnelInfo.lease_mode_youxiaoqi);
		}
		
		model.setUsername(userInfoMVO.getUsername());
		model.setGender(userInfoMVO.getGender());
		model.setFacePhoto(userInfoMVO.getFacePhoto());
		model.setBirthDate(userInfoMVO.getBirthDate());
		model.setNationId(userInfoMVO.getNationId());
		model.setNationName(userInfoMVO.getNationName());
		model.setTelephone(userInfoMVO.getTelephone());
		model.setCertificatesTypeId(userInfoMVO.getCertificatesTypeId());
		model.setCertificatesTypeName(userInfoMVO.getCertificatesTypeName());
		model.setCertificatesPositivePhoto(userInfoMVO.getCertificatesPositivePhoto());
		model.setCertificatesNegativePhoto(userInfoMVO.getCertificatesNegativePhoto());
		model.setCertificatesNumber(userInfoMVO.getCertificatesNumber());
		model.setCertificatesStartTime(userInfoMVO.getCertificatesStartTime());
		model.setCertificatesStopTime(userInfoMVO.getCertificatesStopTime());
		model.setCertificatesAddress(userInfoMVO.getCertificatesAddress());
		model.setCertificatesOffice(userInfoMVO.getCertificatesOffice());
		model.setStatus(PersonnelInfo.status_waiting);
		model.setPerSort(PersonnelInfo.per_sort_app);
		model.setAuditRemark(" ");
		model.setUpdateTime(DateUtil.nowTime());
		model = this.insert(model);
		
		//如果是租赁的上传租赁合同
		////上传租赁合同
		if (!StringUtils.equals(housesInfo.getPropertyOwnerIdcard(), userInfoMVO.getCertificatesNumber()) && StringUtils.isNotBlank(model.getLeaseContract())) {
			List<String> sList = Arrays.asList(model.getLeaseContract().split(","));
			for(int i=0; i< sList.size(); i++){
				ContractFileMVO contractFile = new ContractFileMVO();
				contractFile.setPersonnelId(model.getPersonnelId());
				contractFile.setUserId(model.getUserId());
				contractFile.setHousesId(model.getHousesId());
				contractFile.setFileThumb(sList.get(i));
				contractFile.setCreateTime(DateUtil.nowTime());
				contractFile.setSts(STS_NORMAL);
				contractFileMDAO.insert(contractFile);
			}
		}
		
		HousesInfoMVO housesInfoMVO = new HousesInfoMVO();
		housesInfoMVO.setHousesId(model.getHousesId());
		housesInfoMVO = housesInfoMDAO.queryBean(housesInfoMVO);
		String hname = "";
		if (StringUtils.equals(HousesInfo.houses_status_fangwu, housesInfoMVO.getHousesStatus())) {
			hname = housesInfoMVO.getCommunityName()+" "+housesInfoMVO.getStoriedBuildingNumber()+"-"+housesInfoMVO.getUnit()+"-"+housesInfoMVO.getHouseNumber();
		}
		if (StringUtils.equals(HousesInfo.houses_status_dianpu, housesInfoMVO.getHousesStatus())) {
			hname = model.getEnterpriseName();
		}
				
		MsgTypeMVO msgTypeMVO = new MsgTypeMVO();
		msgTypeMVO.setMsgTypeId("1");
		msgTypeMVO = msgTypeMDAO.queryBean(msgTypeMVO);
		
		String title = model.getLiveTypeName() + msgTypeMVO.getMsgTypeName();
		String content = "您所提交的【"+hname+"】"+model.getLiveTypeName()+"申请【人员姓名："+model.getUsername()+"】已进入审核流程，请耐心等待";
		MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
		msgInfoMVO.setUserId(model.getUserId());
		msgInfoMVO.setPersonnelId(model.getPersonnelId());
		msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
		msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setTitle(title);
		msgInfoMVO.setContent(content);
		msgInfoMVO.setStatus(MsgInfo.status_not_read);
		msgInfoService.insert(msgInfoMVO);
		
		
		try {
			AduitDistributionMVO ad = new AduitDistributionMVO();
			ad.setHousesId(model.getHousesId());
			ad.setSts("A");
			List<AduitDistributionMVO> list = aduitDistributionMDAO.queryList(ad);
			if (list.size() > 0) {
				ad = list.get(0);
				AdminInfoMVO adminInfo = new AdminInfoMVO();
				adminInfo.setAdminId(ad.getAdminId());
				adminInfo = adminInfoMDAO.queryBean(adminInfo);
				String remark = "【"+hname+"】"+model.getLiveTypeName()+"申请【人员姓名："+model.getUsername()+"】已提交申请";
				
				Send_template_message.send_template_message(adminInfo.getWxGzhOpenid(), remark);
				
			}
			PushUtils.toPush(userInfoMVO.getUserId(), userInfoMVO.getOpId(), title, content, type);	
		} catch (Exception e) {
			logger.info("发送通知错误", e);
		}
		
		return model;
	}

	@Override
	public PersonnelInfoMVO addPersonnel(PersonnelInfoMVO model) throws SysException, AppException {
		String userId = model.getUserId();
		UserInfoMVO userInfoMVO = new UserInfoMVO();
		userInfoMVO.setUserId(userId);
		userInfoMVO = userInfoMDAO.queryBean(userInfoMVO);
		
		model.setUserId(null);
		model.setStatus(PersonnelInfo.status_waiting);
		model.setPerSort(PersonnelInfo.per_sort_not_app);
		if (model.getLiveTypeId().equals("7")) {
			model.setLeaseMode(PersonnelInfo.lease_mode_changqi);
		}else{
			model.setLeaseMode(PersonnelInfo.lease_mode_youxiaoqi);
		}
		
		model.setAuditRemark(" ");
		model.setUpdateTime(DateUtil.nowTime());
		model = this.insert(model);
		
		PersonnelInfoMVO personnelInfoMVO = new PersonnelInfoMVO();
		personnelInfoMVO.setHousesId(model.getHousesId());
		personnelInfoMVO.setPerSort(PersonnelInfo.per_sort_app);
		List<PersonnelInfoMVO> list = this.queryList(personnelInfoMVO);
		personnelInfoMVO = list.get(0);
		
		throwAppException(!StringUtils.equals(personnelInfoMVO.getStatus(), PersonnelInfo.status_passed), RC.PERSONNEL_INFO_REPORT_STATUS_NOT_PASS);
		
		HousesInfoMVO housesInfoMVO = new HousesInfoMVO();
		housesInfoMVO.setHousesId(model.getHousesId());
		housesInfoMVO = housesInfoMDAO.queryBean(housesInfoMVO);
		String hname = "";
		if (StringUtils.equals(HousesInfo.houses_status_fangwu, housesInfoMVO.getHousesStatus())) {
			hname = housesInfoMVO.getCommunityName()+" "+housesInfoMVO.getStoriedBuildingNumber()+"-"+housesInfoMVO.getUnit()+"-"+housesInfoMVO.getHouseNumber();
		}
		if (StringUtils.equals(HousesInfo.houses_status_dianpu, housesInfoMVO.getHousesStatus())) {
			hname = personnelInfoMVO.getEnterpriseName();
		}
				
		MsgTypeMVO msgTypeMVO = new MsgTypeMVO();
		msgTypeMVO.setMsgTypeId("1");
		msgTypeMVO = msgTypeMDAO.queryBean(msgTypeMVO);
		
		String title = model.getLiveTypeName() + msgTypeMVO.getMsgTypeName();
		String content = "您所提交的【"+hname+"】"+model.getLiveTypeName()+"申请【人员姓名："+model.getUsername()+"】已进入审核流程，请耐心等待";
		MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
		msgInfoMVO.setUserId(userId);
		msgInfoMVO.setPersonnelId(model.getPersonnelId());
		msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
		msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setTitle(title);
		msgInfoMVO.setContent(content);
		msgInfoMVO.setStatus(MsgInfo.status_not_read);
		msgInfoService.insert(msgInfoMVO);
		String type = "";
		if (model.getLiveTypeId().equals("5")) {
			type = "z0201";
		}
		if (model.getLiveTypeId().equals("6")) {
			type = "z0208";
		}
		if (model.getLiveTypeId().equals("7")) {
			type = "z0205";
		}
		
		try {
			AduitDistributionMVO ad = new AduitDistributionMVO();
			ad.setHousesId(personnelInfoMVO.getHousesId());
			ad.setSts("A");
			List<AduitDistributionMVO> list2 = aduitDistributionMDAO.queryList(ad);
			if (list.size() > 0) {
				ad = list2.get(0);
				AdminInfoMVO adminInfo = new AdminInfoMVO();
				adminInfo.setAdminId(ad.getAdminId());
				adminInfo = adminInfoMDAO.queryBean(adminInfo);
				String remark = "【"+hname+"】"+model.getLiveTypeName()+"申请【人员姓名："+model.getUsername()+"】已提交申请";
				try {
					Send_template_message.send_template_message(adminInfo.getWxGzhOpenid(), remark);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			PushUtils.toPush(userId, userInfoMVO.getOpId(), title, content, type);	
		} catch (Exception e) {
			logger.info("发送通知错误", e);
		}
		return model;
	}

	@Override
	public int updatePersonnel(PersonnelInfoMVO entity) throws SysException, AppException {
		
		PersonnelInfoMVO personnelInfoMVO = this.queryBean(entity);
		
		PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
		personnelInfo.setHousesId(personnelInfoMVO.getHousesId());
		personnelInfo.setPerSort(PersonnelInfo.per_sort_app);
		List<PersonnelInfoMVO> list = this.queryList(personnelInfo);
		personnelInfo = list.get(0);
		
		UserInfoMVO userInfoMVO = new UserInfoMVO();
		userInfoMVO.setUserId(personnelInfo.getUserId());
		userInfoMVO = userInfoMDAO.queryBean(userInfoMVO);
		
		MsgTypeMVO msgTypeMVO = new MsgTypeMVO();
		msgTypeMVO.setMsgTypeId("5");
		msgTypeMVO = msgTypeMDAO.queryBean(msgTypeMVO);
		
		String title = msgTypeMVO.getMsgTypeName();
		String content = "您所提交的【身份信息更新审核】已进入审核流程，请耐心等待";
				
		MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
		msgInfoMVO.setUserId(personnelInfo.getUserId());
		msgInfoMVO.setPersonnelId(personnelInfoMVO.getPersonnelId());
		msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
		msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setTitle(title);
		msgInfoMVO.setContent(content);
		msgInfoMVO.setStatus(MsgInfo.status_not_read);
		msgInfoService.insert(msgInfoMVO);
		
		HousesInfoMVO housesInfoMVO = new HousesInfoMVO();
		housesInfoMVO.setHousesId(personnelInfoMVO.getHousesId());
		housesInfoMVO = housesInfoMDAO.queryBean(housesInfoMVO);
		String hname = "";
		if (StringUtils.equals(HousesInfo.houses_status_fangwu, housesInfoMVO.getHousesStatus())) {
			hname = housesInfoMVO.getCommunityName()+" "+housesInfoMVO.getStoriedBuildingNumber()+"-"+housesInfoMVO.getUnit()+"-"+housesInfoMVO.getHouseNumber();
		}
		if (StringUtils.equals(HousesInfo.houses_status_dianpu, housesInfoMVO.getHousesStatus())) {
			hname = personnelInfoMVO.getEnterpriseName();
		}
		
		
		
		try {
			AduitDistributionMVO ad = new AduitDistributionMVO();
			ad.setHousesId(personnelInfoMVO.getHousesId());
			ad.setSts("A");
			List<AduitDistributionMVO> list2 = aduitDistributionMDAO.queryList(ad);
			if (list.size() > 0) {
				ad = list2.get(0);
				AdminInfoMVO adminInfo = new AdminInfoMVO();
				adminInfo.setAdminId(ad.getAdminId());
				adminInfo = adminInfoMDAO.queryBean(adminInfo);
				String remark = "【"+hname+"】"+personnelInfoMVO.getLiveTypeName()+"申请【人员姓名："+personnelInfoMVO.getUsername()+"】已提交申请";
				try {
					Send_template_message.send_template_message(adminInfo.getWxGzhOpenid(), remark);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			PushUtils.toPush(personnelInfo.getUserId(), userInfoMVO.getOpId(),title, content, "z0301");	
		} catch (Exception e) {
			logger.info("发送通知错误", e);
		}

		entity.setStatus(PersonnelInfo.status_waiting);
		entity.setUpdateStatus(PersonnelInfo.update_status_again);
		return this.update(entity);
	}

	@Override
	public int updateAuditPersonnel(PersonnelInfoMVO entity) throws SysException, AppException {
		
		PersonnelInfoMVO per = personnelInfoMDAO.queryBean(entity);
		
		PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
		personnelInfo.setHousesId(per.getHousesId());
		personnelInfo.setPerSort(PersonnelInfo.per_sort_app);
		List<PersonnelInfoMVO> list = this.queryList(personnelInfo);
		personnelInfo = list.get(0);
		
		UserInfoMVO userInfoMVO = new UserInfoMVO();
		userInfoMVO.setUserId(personnelInfo.getUserId());
		userInfoMVO = userInfoMDAO.queryBean(userInfoMVO);
		
		HousesInfoMVO housesInfoMVO = new HousesInfoMVO();
		housesInfoMVO.setHousesId(per.getHousesId());
		housesInfoMVO = housesInfoMDAO.queryBean(housesInfoMVO);
		
		String type = "";
		int integralType = 0;
		String integralContent = "";
		String hname = "";
		if (StringUtils.equals(HousesInfo.houses_status_fangwu, housesInfoMVO.getHousesStatus())) {
			hname = housesInfoMVO.getCommunityName()+" "+housesInfoMVO.getStoriedBuildingNumber()+"-"+housesInfoMVO.getUnit()+"-"+housesInfoMVO.getHouseNumber();
		}
		if (StringUtils.equals(HousesInfo.houses_status_dianpu, housesInfoMVO.getHousesStatus())) {
			hname = per.getEnterpriseName();
		}
		//房主
		if(per.getLiveTypeId().equals("1") || per.getLiveTypeId().equals("3")){
			if(entity.getStatus().equals(PersonnelInfo.status_passed)){
				type = "z0102";
				integralType = 31;
				integralContent = "完成业主申请通过";
			}
			if(entity.getStatus().equals(PersonnelInfo.status_reject)){
				type = "z0103";
			}
		}
		//店主
		if(per.getLiveTypeId().equals("2") || per.getLiveTypeId().equals("4")){
			if(entity.getStatus().equals(PersonnelInfo.status_passed)){
				type = "z0102";
				integralType = 31;
				integralContent = "完成业主申请通过";
			}
			if(entity.getStatus().equals(PersonnelInfo.status_reject)){
				type = "z0103";
			}
		}
		//租户
		if(per.getLiveTypeId().equals("5")){
			if(entity.getStatus().equals(PersonnelInfo.status_passed)){
				type = "z0202";
				integralType = 32;
				integralContent = "完成租户申请通过";
			}
			if(entity.getStatus().equals(PersonnelInfo.status_reject)){
				type = "z0203";
			}
		}
		//员工
		if(per.getLiveTypeId().equals("6")){
			if(entity.getStatus().equals(PersonnelInfo.status_passed)){
				type = "z0209";
				integralType = 32;
				integralContent = "完成员工申请通过";
			}
			if(entity.getStatus().equals(PersonnelInfo.status_reject)){
				type = "z0209";
			}
		}
		//家属
		if(per.getLiveTypeId().equals("7")){
			if(entity.getStatus().equals(PersonnelInfo.status_passed)){
				type = "z0206";
				integralType = 32;
				integralContent = "完成家属申请通过";
			}
			if(entity.getStatus().equals(PersonnelInfo.status_reject)){
				type = "z0207";
			}
		}
		
		
		
		if (StringUtils.equals(entity.getStatus(), PersonnelInfo.status_passed)) {
			//添加居住时间
			entity.setLeaseStartTime(DateUtil.nowTime());
			//如果是更新上报
			if (per.getUpdateStatus().equals(PersonnelInfo.update_status_again)) {
				type = "z0302";
				integralType = 33;
				integralContent = "完成信息更新申请通过";
			}
			MsgTypeMVO msgTypeMVO = new MsgTypeMVO();
			msgTypeMVO.setMsgTypeId("4");
			msgTypeMVO = msgTypeMDAO.queryBean(msgTypeMVO);
			
			String title = per.getLiveTypeName() + msgTypeMVO.getMsgTypeName();
			String content = "您所提交的【"+hname+"】"+per.getLiveTypeName()+"申请【人员姓名："+per.getUsername()+"】已通过审核，请悉知";
			
			MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
			msgInfoMVO.setUserId(userInfoMVO.getUserId());
			msgInfoMVO.setPersonnelId(entity.getPersonnelId());
			msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
			msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
			msgInfoMVO.setTitle(title);
			msgInfoMVO.setContent(content);
			msgInfoMVO.setStatus(MsgInfo.status_not_read);
			msgInfoService.insert(msgInfoMVO);
			
			try {
				//通知
				PushUtils.toPush(userInfoMVO.getUserId(), userInfoMVO.getOpId(), title, content, type);
				//积分
				PushUtils.toIntegral(userInfoMVO.getUserId(), integralContent, integralType);
			} catch (Exception e) {
				logger.info("发送通知错误", e);
			}
			
		}else if (StringUtils.equals(entity.getStatus(), PersonnelInfo.status_reject)) {
			//如果是更新上报
			if (per.getUpdateStatus().equals(PersonnelInfo.update_status_again)) {
				type = "z0303";
			}
			MsgTypeMVO msgTypeMVO = new MsgTypeMVO();
			msgTypeMVO.setMsgTypeId("3");
			msgTypeMVO = msgTypeMDAO.queryBean(msgTypeMVO);
			
			String title = per.getLiveTypeName() + msgTypeMVO.getMsgTypeName();
			String content = "您所提交的【"+hname+"】"+per.getLiveTypeName()+"申请【人员姓名："+per.getUsername()+"】已通过审核，请悉知";
			
			MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
			msgInfoMVO.setUserId(userInfoMVO.getUserId());
			msgInfoMVO.setPersonnelId(entity.getPersonnelId());
			msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
			msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
			msgInfoMVO.setTitle(title);
			msgInfoMVO.setContent(content);
			msgInfoMVO.setStatus(MsgInfo.status_not_read);
			msgInfoService.insert(msgInfoMVO);
			try {
				
				PushUtils.toPush(userInfoMVO.getUserId(), userInfoMVO.getOpId(), title, content, type);	
			} catch (Exception e) {
				logger.info("发送通知错误", e);
			}
		}
		return personnelInfoMDAO.update(entity);
	}

	@Override
	public List<PersonnelInfoMVO> queryPerList(PersonnelInfoMVO entity) throws SysException, AppException {
		return personnelInfoMDAO.queryPerList(entity);
	}

	@Override
	public int updateUserPersonnel(PersonnelInfoMVO entity) throws SysException, AppException {
		// TODO Auto-generated method stub
		return 0;
	}

}
