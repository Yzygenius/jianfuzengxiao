package com.jianfuzengxiao.pub.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.pub.dao.IHousesInfoMDAO;
import com.jianfuzengxiao.pub.dao.IMsgTypeMDAO;
import com.jianfuzengxiao.pub.dao.IPersonnelInfoMDAO;
import com.jianfuzengxiao.pub.dao.IUserInfoMDAO;
import com.jianfuzengxiao.pub.entity.HousesInfo;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.MsgInfo;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
import com.jianfuzengxiao.pub.entity.MsgTypeMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfo;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IMsgInfoService;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;

@Service
public class PersonnelInfoService extends BaseService implements IPersonnelInfoService {

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

	/** 插入 */
	@Override
	public PersonnelInfoMVO insert(PersonnelInfoMVO personnelInfo) throws SysException, AppException {
		personnelInfo.setCreateTime(DateUtil.nowTime());
		personnelInfo.setSts(STS_NORMAL);
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
		//判断是否为自持
		/*model.setLiveTypeId();
		model.setLiveTypeName();
		model.setLeaseMode();
		model.setLeaseStartTime();
		model.setLeaseStopTime();*/
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
		this.insert(model);
		
		//如果是租赁的上传租赁合同
		//
		
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
		
		MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
		msgInfoMVO.setUserId(model.getUserId());
		msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
		msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setTitle(model.getLiveTypeName() + msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setContent("您所提交的【"+hname+"】"+model.getLiveTypeName()+"申请【人员姓名："+model.getUsername()+"】已进入审核流程，请耐心等待");
		msgInfoMVO.setStatus(MsgInfo.status_not_read);
		msgInfoService.insert(msgInfoMVO);
		
		return model;
	}

	@Override
	public PersonnelInfoMVO addPersonnel(PersonnelInfoMVO model) throws SysException, AppException {
		
		model.setUserId(null);
		this.insert(model);
		
		PersonnelInfoMVO personnelInfoMVO = new PersonnelInfoMVO();
		personnelInfoMVO.setHousesId(model.getHousesId());
		personnelInfoMVO.setPerSort(PersonnelInfo.per_sort_app);
		List<PersonnelInfoMVO> list = this.queryList(personnelInfoMVO);
		personnelInfoMVO = list.get(0);
		
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
		
		MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
		msgInfoMVO.setUserId(model.getUserId());
		msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
		msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setTitle(model.getLiveTypeName() + msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setContent("您所提交的【"+hname+"】"+model.getLiveTypeName()+"申请【人员姓名："+model.getUsername()+"】已进入审核流程，请耐心等待");
		msgInfoMVO.setStatus(MsgInfo.status_not_read);
		msgInfoService.insert(msgInfoMVO);
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
		
		MsgTypeMVO msgTypeMVO = new MsgTypeMVO();
		msgTypeMVO.setMsgTypeId("5");
		msgTypeMVO = msgTypeMDAO.queryBean(msgTypeMVO);
		
		MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
		msgInfoMVO.setUserId(personnelInfo.getUserId());
		msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
		msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setTitle(msgTypeMVO.getMsgTypeName());
		msgInfoMVO.setContent("您所提交的【身份信息更新审核】已进入审核流程，请耐心等待");
		msgInfoMVO.setStatus(MsgInfo.status_not_read);
		msgInfoService.insert(msgInfoMVO);
		
		return this.update(entity);
	}

}
