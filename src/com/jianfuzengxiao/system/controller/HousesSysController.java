package com.jianfuzengxiao.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.common.SessionAdmin;
import com.jianfuzengxiao.base.controller.BaseController;
import com.jianfuzengxiao.pub.entity.AdminInfoMVO;
import com.jianfuzengxiao.pub.entity.AduitDistributionMVO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.service.IAdminInfoService;
import com.jianfuzengxiao.pub.service.IAduitDistributionService;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.jianfuzengxiao.pub.service.IPersonnelInfoService;
import com.jianfuzengxiao.pub.service.IUserInfoService;

@Controller
@RequestMapping(value="/system/houses")
public class HousesSysController extends BaseController {
private static Logger logger = LoggerFactory.getLogger(HousesSysController.class);
	
	@Autowired
	private IHousesInfoService housesInfoService;
	
	@Autowired
	private IPersonnelInfoService personnelInfoService;
	
	@Autowired
	private IAduitDistributionService aduitDistributionService;
	
	@Autowired
	private IAdminInfoService adminInfoService;
	
	@RequestMapping(value="/toHousesFwPage")
	public String toHousesFwPage(){
		return "/system/housesFw-page";
	}
	
	@RequestMapping(value="/toAddHousesFw")
	public String toAddHousesFw(){
		return "/system/housesFw-add";
	}
	
	@RequestMapping(value="/toUpdateHousesFw")
	public String toUpdateHousesFw(Model model, HousesInfoMVO entity){
		try {
			entity = housesInfoService.queryBean(entity);
			model.addAttribute("houses", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/housesFw-update";
	}
	
	@RequestMapping(value="/toHousesFwDetail")
	public String toHousesFwDetail(Model model, HousesInfoMVO entity){
		try {
			entity = housesInfoService.queryBean(entity);
			AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
			aduitDistribution.setHousesId(entity.getHousesId());
			aduitDistribution.setSts("A");
			List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
			
			if (list.size() > 0) {
				aduitDistribution = list.get(0);
				AdminInfoMVO adminInfo = new AdminInfoMVO();
				adminInfo.setAdminId(aduitDistribution.getAdminId());
				adminInfo = adminInfoService.queryBean(adminInfo);
				entity.setAdminTelephone(adminInfo.getTelephone());
				entity.setUsername(adminInfo.getUsername());
			}
			
			PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
			personnelInfo.setHousesId(entity.getHousesId());
			personnelInfo.setLiveTypeId("1,2,3,4");
			personnelInfo.setSts("A");
			List<PersonnelInfoMVO> list2 = personnelInfoService.queryList(personnelInfo);
			if(list2.size() > 0){
				personnelInfo = list2.get(0);
				entity.setFangzhu(personnelInfo.getUsername());
				entity.setEnterpriseName(personnelInfo.getEnterpriseName());
				entity.setFangzhuTel(personnelInfo.getTelephone());
			}
			model.addAttribute("houses", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/housesFw-detail";
	}
	
	//店铺
	@RequestMapping(value="/toHousesDpPage")
	public String toHousesDpPage(){
		return "/system/housesDp-page";
	}
	
	@RequestMapping(value="/toAddHousesDp")
	public String toAddHousesDp(){
		return "/system/housesDp-add";
	}
	
	@RequestMapping(value="/toUpdateHousesDp")
	public String toUpdateHousesDp(Model model, HousesInfoMVO entity){
		try {
			entity = housesInfoService.queryBean(entity);
			model.addAttribute("houses", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/housesDp-update";
	}
	
	@RequestMapping(value="/toHousesDpDetail")
	public String toHousesDpDetail(Model model, HousesInfoMVO entity){
		try {
			entity = housesInfoService.queryBean(entity);
			AduitDistributionMVO aduitDistribution = new AduitDistributionMVO();
			aduitDistribution.setHousesId(entity.getHousesId());
			aduitDistribution.setSts("A");
			List<AduitDistributionMVO> list = aduitDistributionService.queryList(aduitDistribution);
			
			if (list.size() > 0) {
				aduitDistribution = list.get(0);
				AdminInfoMVO adminInfo = new AdminInfoMVO();
				adminInfo.setAdminId(aduitDistribution.getAdminId());
				adminInfo = adminInfoService.queryBean(adminInfo);
				entity.setAdminTelephone(adminInfo.getTelephone());
				entity.setUsername(adminInfo.getUsername());
			}
			
			PersonnelInfoMVO personnelInfo = new PersonnelInfoMVO();
			personnelInfo.setHousesId(entity.getHousesId());
			personnelInfo.setLiveTypeId("1,2,3,4");
			personnelInfo.setSts("A");
			List<PersonnelInfoMVO> list2 = personnelInfoService.queryList(personnelInfo);
			if(list2.size() > 0){
				personnelInfo = list2.get(0);
				entity.setFangzhu(personnelInfo.getUsername());
				entity.setEnterpriseName(personnelInfo.getEnterpriseName());
				entity.setFangzhuTel(personnelInfo.getTelephone());
			}
			model.addAttribute("houses", entity);
		} catch (Exception e) {
			return "/system/error";
		}
		return "/system/housesFw-detail";
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 房产下居住人列表
	 * </p>
	 * @param entity
	 * @return    
	 * String    返回类型 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年11月7日 下午4:30:34
	 */
	@ResponseBody
	@RequestMapping(value="/getPerPage", method=RequestMethod.POST)
	public String getPerPage(PersonnelInfoMVO entity){
		try{
			PageInfo pageInfo = getPage();
			entity.setSts("A");
			pageInfo = personnelInfoService.queryPage(entity, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "获取人员列表失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 添加房屋或门店
	 * </p>
	 * @param housesStatus 类型(1房屋、2门店), propertyOwnerName 房屋（门店）产权人姓名, propertyOwnerTel 房屋（门店）产权人联系电话, propertyOwnerIdcard 房屋（门店）产权人身份证号<br>
	 	propertyCertificatesNumber 房屋（门店）产权证号, propertyCertificatesPhoto 房屋（门店）房产证照片, communityId 社区类型id, communityName 社区类型名称<br>
	 	communityStreetId 小区或街道id, communityStreetName 小区或街道名称, houseType 房屋（门店）户型 , houseTypePhoto 房屋（门店）户型图, storiedBuildingNumber 房屋楼号<br>
	 	unit 房屋单元, houseNumber 门牌号, housesAddress 房屋（门店）详细地址, housesTypeId 房屋类型id, housesTypeName 房屋类型名称, storeLocation 门店0无1内/2外铺<br>
	 	provName provCode 省, cityName cityCode 市, areaName areaCode 区/县 ,
	 * @return 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午1:52:22
	 */
	@ResponseBody
	@RequestMapping(value="addHouses", method=RequestMethod.POST)
	public String addHouses(HousesInfoMVO model){
		try {
			model.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
			housesInfoService.insert(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "添加房屋或门店失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询自有的房屋或门店列表，分页
	 * </p>
	 * @param userid
	 * @return housesId 房屋ID,housesStatus 类型(1房屋、2门店), propertyOwnerName 房屋（门店）产权人姓名, propertyOwnerTel 房屋（门店）产权人联系电话, propertyOwnerIdcard 房屋（门店）产权人身份证号<br>
	 	propertyCertificatesNumber 房屋（门店）产权证号, propertyCertificatesPhoto 房屋（门店）房产证照片, communityId 社区类型id, communityName 社区类型名称<br>
	 	communityStreetId 小区或街道id, communityStreetName 小区或街道名称, houseType 房屋（门店）户型 , houseTypePhoto 房屋（门店）户型图, storiedBuildingNumber 房屋楼号<br>
	 	unit 房屋单元, houseNumber 门牌号, housesAddress 房屋（门店）详细地址, housesTypeId 房屋类型id, housesTypeName 房屋类型名称, storeLocation 门店0无1内/2外铺<br>
	 	provName provCode 省, cityName cityCode 市, areaName areaCode 区/县 , 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午2:30:02
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesPage", method=RequestMethod.POST)
	public String getHousesPage(HousesInfoMVO model){
		try {
			if (StringUtils.equals(SessionAdmin.get(SessionAdmin.ROLE_ID), "2")) {
				model.setAdminId(SessionAdmin.get(SessionAdmin.ADMIN_ID));
			}
			PageInfo pageInfo = getPage();
			model.setSts("A");
			pageInfo = housesInfoService.queryPage(model, pageInfo);
			return apiResult(RC.SUCCESS, pageInfo);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房屋或门店失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询自有的房屋或门店列表
	 * </p>
	 * @param userid
	 * @return housesId 房屋ID, housesStatus 类型(1房屋、2门店), propertyOwnerName 房屋（门店）产权人姓名, propertyOwnerTel 房屋（门店）产权人联系电话, propertyOwnerIdcard 房屋（门店）产权人身份证号<br>
	 	propertyCertificatesNumber 房屋（门店）产权证号, propertyCertificatesPhoto 房屋（门店）房产证照片, communityId 社区类型id, communityName 社区类型名称<br>
	 	communityStreetId 小区或街道id, communityStreetName 小区或街道名称, houseType 房屋（门店）户型 , houseTypePhoto 房屋（门店）户型图, storiedBuildingNumber 房屋楼号<br>
	 	unit 房屋单元, houseNumber 门牌号, housesAddress 房屋（门店）详细地址, housesTypeId 房屋类型id, housesTypeName 房屋类型名称, storeLocation 门店0无1内/2外铺<br>
	 	provName provCode 省, cityName cityCode 市, areaName areaCode 区/县 , 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午2:30:02
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesList", method=RequestMethod.POST)
	public String getHousesList(HousesInfoMVO model){
		try {
			model.setSts("A");
			List<HousesInfoMVO> list = housesInfoService.queryList(model);
			return apiResult(RC.SUCCESS, list);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房屋或门店失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 查询自有的房屋或门店详情
	 * </p>
	 * @param housesId
	 * @return housesId 房屋ID,housesStatus 类型(1房屋、2门店), propertyOwnerName 房屋（门店）产权人姓名, propertyOwnerTel 房屋（门店）产权人联系电话, propertyOwnerIdcard 房屋（门店）产权人身份证号<br>
	 	propertyCertificatesNumber 房屋（门店）产权证号, propertyCertificatesPhoto 房屋（门店）房产证照片, communityId 社区类型id, communityName 社区类型名称<br>
	 	communityStreetId 小区或街道id, communityStreetName 小区或街道名称, houseType 房屋（门店）户型 , houseTypePhoto 房屋（门店）户型图, storiedBuildingNumber 房屋楼号<br>
	 	unit 房屋单元, houseNumber 门牌号, housesAddress 房屋（门店）详细地址, housesTypeId 房屋类型id, housesTypeName 房屋类型名称, storeLocation 门店0无1内/2外铺<br>
	 	provName provCode 省, cityName cityCode 市, areaName areaCode 区/县 , 
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午2:30:02
	 */
	@ResponseBody
	@RequestMapping(value="/getHousesDetail", method=RequestMethod.POST)
	public String getHousesDetail(HousesInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			model = housesInfoService.queryBean(model);
			return apiResult(RC.SUCCESS, model);
		} catch (Exception e) {
			return exceptionResult(logger, "查询房屋或门店失败", e);
		}
	}
	
	/**
	 * 
	 * <p style="color:#36F;">
	 * 修改房屋或门店信息
	 * </p>
	 * @param  housesId 房屋ID, userid 用户ID,housesStatus 类型(1房屋、2门店), propertyOwnerName 房屋（门店）产权人姓名, propertyOwnerTel 房屋（门店）产权人联系电话, propertyOwnerIdcard 房屋（门店）产权人身份证号<br>
	 	propertyCertificatesNumber 房屋（门店）产权证号, propertyCertificatesPhoto 房屋（门店）房产证照片, communityId 社区类型id, communityName 社区类型名称<br>
	 	communityStreetId 小区或街道id, communityStreetName 小区或街道名称, houseType 房屋（门店）户型 , houseTypePhoto 房屋（门店）户型图, storiedBuildingNumber 房屋楼号<br>
	 	unit 房屋单元, houseNumber 门牌号, housesAddress 房屋（门店）详细地址, housesTypeId 房屋类型id, housesTypeName 房屋类型名称, storeLocation 门店0无1内/2外铺<br>
	 	provName provCode 省, cityName cityCode 市, areaName areaCode 区/县 , 
	 * @return
	 * @throws 
	 * @author 闫子扬 
	 * @date 2019年10月28日 下午2:30:02
	 */
	@ResponseBody
	@RequestMapping(value="/updateHouses", method=RequestMethod.POST)
	public String updateHouses(HousesInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			housesInfoService.update(model);
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "修改房屋或门店失败", e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delHouses", method=RequestMethod.POST)
	public String delHouses(HousesInfoMVO model){
		try {
			throwAppException(StringUtils.isBlank(model.getHousesId()), RC.HOUSES_INFO_PARAM_HOUSES_ID_INVALID);
			List<String> list = Arrays.asList(model.getHousesId().split(","));
			for(int i=0; i<list.size(); i++){
				HousesInfoMVO eneity = new HousesInfoMVO();
				eneity.setHousesId(list.get(i));
				eneity.setSts("P");
				housesInfoService.update(eneity);
			}
			return apiResult(RC.SUCCESS);
		} catch (Exception e) {
			return exceptionResult(logger, "删除失败", e);
		}
	}
}
