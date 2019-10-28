package com.jianfuzengxiao.api.controller;

import static com.jianfuzengxiao.base.utils.ApiUtil.throwAppException;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.service.IHousesInfoService;
import com.bamboo.framework.entity.PageInfo;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.controller.BaseController;

@Controller
@RequestMapping(value="/api/housesInfo")
public class HousesInfoAPIController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(HousesInfoAPIController.class);
	
	@Autowired
	private IHousesInfoService housesInfoService;
	
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
			PageInfo pageInfo = getPage();
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
}
