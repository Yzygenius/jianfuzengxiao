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
import com.jianfuzengxiao.pub.dao.IMsgInfoMDAO;
import com.jianfuzengxiao.pub.dao.IMsgTypeMDAO;
import com.jianfuzengxiao.pub.dao.IUserInfoMDAO;
import com.jianfuzengxiao.pub.entity.HousesInfo;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.MsgInfo;
import com.jianfuzengxiao.pub.entity.MsgInfoMVO;
import com.jianfuzengxiao.pub.entity.MsgTypeMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfo;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.entity.UserInfo;
import com.jianfuzengxiao.pub.entity.UserInfoMVO;
import com.jianfuzengxiao.pub.service.IMsgInfoService;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;
import com.jianfuzengxiao.pub.service.IUserInfoService;

@Service
public class UserInfoService extends BaseService implements IUserInfoService {

	@Autowired
	private IUserInfoMDAO userInfoMDAO;
	
	@Autowired
	private IMsgInfoService msgInfoService;
	
	@Autowired
	private IMsgTypeMDAO msgTypeMDAO;
	
	@Autowired
	private IPersonnelInfoService personnelInfoService;

	/** 插入 */
	@Override
	public UserInfoMVO insert(UserInfoMVO userInfo) throws SysException, AppException {
		userInfo.setCreateTime(DateUtil.nowTime());
		userInfo.setSts(STS_NORMAL);
		return userInfoMDAO.insert(userInfo);
	}

	/** 更新 */
	@Override
	public int update(UserInfoMVO userInfo) throws SysException, AppException {
		userInfo.setUpdateTime(DateUtil.nowTime());
		return userInfoMDAO.update(userInfo);
	}

	/** 删除 */
	@Override
	public int delete(UserInfoMVO userInfo) throws SysException, AppException {
		return userInfoMDAO.delete(userInfo);
	}

	/** 查询集合列表 */
	@Override
	public List<UserInfoMVO> queryList(UserInfoMVO userInfo) throws SysException, AppException {
		return userInfoMDAO.queryList(userInfo);
	}

	/** 查询对象 */
	@Override
	public UserInfoMVO queryBean(UserInfoMVO userInfo) throws SysException, AppException {
		return userInfoMDAO.queryBean(userInfo);
	}

	/** 分页查询 */
	@Override
	public PageInfo queryPage(UserInfoMVO userInfo, PageInfo pagInfo) throws SysException, AppException {
		return userInfoMDAO.queryPage(userInfo, pagInfo);
	}

	@Override
	public int updateAuditUser(UserInfoMVO entity) throws SysException, AppException {
		UserInfoMVO user = userInfoMDAO.queryBean(entity);
		
		this.update(entity);
		
		if (StringUtils.equals(entity.getStatus(), PersonnelInfo.status_passed)) {
			MsgTypeMVO msgTypeMVO = new MsgTypeMVO();
			msgTypeMVO.setMsgTypeId("4");
			msgTypeMVO = msgTypeMDAO.queryBean(msgTypeMVO);
			
			MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
			msgInfoMVO.setUserId(user.getUserId());
			msgInfoMVO.setPersonnelId("0");
			msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
			msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
			msgInfoMVO.setTitle(msgTypeMVO.getMsgTypeName());
			msgInfoMVO.setContent("您所提交的会员认证申请已通过审核，请悉知");
			msgInfoMVO.setStatus(MsgInfo.status_not_read);
			msgInfoService.insert(msgInfoMVO);
		}else if (StringUtils.equals(entity.getStatus(), PersonnelInfo.status_reject)) {
			MsgTypeMVO msgTypeMVO = new MsgTypeMVO();
			msgTypeMVO.setMsgTypeId("3");
			msgTypeMVO = msgTypeMDAO.queryBean(msgTypeMVO);
			
			MsgInfoMVO msgInfoMVO = new MsgInfoMVO();
			msgInfoMVO.setUserId(user.getUserId());
			msgInfoMVO.setPersonnelId("0");
			msgInfoMVO.setMsgTypeId(msgTypeMVO.getMsgTypeId());
			msgInfoMVO.setMsgTypeName(msgTypeMVO.getMsgTypeName());
			msgInfoMVO.setTitle(msgTypeMVO.getMsgTypeName());
			msgInfoMVO.setContent("您所提交的会员认证申请未能通过审核，请悉知");
			msgInfoMVO.setStatus(MsgInfo.status_not_read);
			msgInfoService.insert(msgInfoMVO);
		}
		return 1;
	}

	@Override
	public int updateUserPer(UserInfoMVO entity) throws SysException, AppException {
		if(StringUtils.isNotBlank(entity.getPersonnelId())){
			PersonnelInfoMVO per = new PersonnelInfoMVO();
			per.setPersonnelId(entity.getPersonnelId());
			per.setLeaseStartTime(entity.getLeaseStartTime());
			per.setLeaseStopTime(entity.getLeaseStopTime());
			per.setUsername(entity.getUsername());
			per.setGender(entity.getGender());
			per.setFacePhoto(entity.getFacePhoto());
			per.setBirthDate(entity.getBirthDate());
			per.setNationId(entity.getNationId());
			per.setNationName(entity.getNationName());
			per.setTelephone(entity.getTelephone());
			per.setCertificatesTypeId(entity.getCertificatesTypeId());
			per.setCertificatesTypeName(entity.getCertificatesTypeName());
			per.setCertificatesPositivePhoto(entity.getCertificatesPositivePhoto());
			per.setCertificatesNegativePhoto(entity.getCertificatesNegativePhoto());
			per.setCertificatesNumber(entity.getCertificatesNumber());
			per.setCertificatesStartTime(entity.getCertificatesStartTime());
			per.setCertificatesStopTime(entity.getCertificatesStopTime());
			per.setCertificatesAddress(entity.getCertificatesAddress());
			per.setCertificatesOffice(entity.getCertificatesOffice());
			personnelInfoService.update(per);
		}
		entity.setStatus(UserInfo.status_waiting);
		return this.update(entity);
	}

}
