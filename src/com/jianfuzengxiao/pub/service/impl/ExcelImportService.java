package com.jianfuzengxiao.pub.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bamboo.framework.base.impl.BaseService;
import com.bamboo.framework.cache.CacheManager;
import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.base.common.Constant;
import com.jianfuzengxiao.base.common.DataFileUtil;
import com.jianfuzengxiao.base.utils.ApiUtil;
import com.jianfuzengxiao.pub.dao.ICommunityInfoMDAO;
import com.jianfuzengxiao.pub.dao.ICommunityStreetInfoMDAO;
import com.jianfuzengxiao.pub.dao.IHousesInfoMDAO;
import com.jianfuzengxiao.pub.dao.IPersonnelInfoMDAO;
import com.jianfuzengxiao.pub.entity.CommunityInfoMVO;
import com.jianfuzengxiao.pub.entity.CommunityStreetInfoMVO;
import com.jianfuzengxiao.pub.entity.HousesInfo;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfo;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;
import com.jianfuzengxiao.pub.service.IExcelImportService;
import com.jianfuzengxiao.system.controller.CommonSysContoller;

@Service
public class ExcelImportService extends BaseService implements IExcelImportService {
	private static Logger logger = LoggerFactory.getLogger(ExcelImportService.class);

	@Autowired
	private IPersonnelInfoMDAO personnelInfoMDAO;
	
	@Autowired
	private IHousesInfoMDAO housesInfoMDAO;
	
	@Autowired
	private ICommunityInfoMDAO communityInfoMDAO;
	
	@Autowired
	private ICommunityStreetInfoMDAO communityStreetInfoMDAO;
	

	@Override
	public boolean addFangwuExcel(String filePath) throws Exception {
		Map<String, String> map = null;
		List<HousesInfoMVO> list = new ArrayList<HousesInfoMVO>();
		// 判断是否为excel类型文件
		if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
			System.out.println("文件不是excel类型");
		}
		//System.out.println(filePath);
		FileInputStream fis = null;
		Workbook wookbook = null;
		Sheet sheet = null;
		try {
			// 获取一个绝对地址的流
			fis = new FileInputStream(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (filePath.endsWith(".xls")) {
				// 2003版本的excel，用.xls结尾
				wookbook = new HSSFWorkbook(fis);
			}else if (filePath.endsWith(".xlsx")) {
				// 2007版本的excel，用.xlsx结尾
				wookbook = new XSSFWorkbook(fis);
			}
		} catch (Exception e) {
			logger.info("导入excel出错", e);
		}
		
		Map<String, PictureData> maplist = null;
	
		sheet = wookbook.getSheetAt(0);
		
		// 判断用07还是03的方法获取图片
		if (filePath.endsWith(".xls")) {
			maplist = getPictures1((HSSFSheet) sheet);
		} else if (filePath.endsWith(".xlsx")) {
			maplist = getPictures2((XSSFSheet) sheet);
		}
		try {
			map = printImg(maplist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 得到一个工作表

		// 获得表头
		/*Row rowHead = sheet.getRow(0);

		// 判断表头是否正确
		System.out.println(rowHead.getPhysicalNumberOfCells());
		if (rowHead.getPhysicalNumberOfCells() != 8) {
			System.out.println("表头的数量不对!");
		}*/

		// 获得数据的总行数
		int totalRowNum = sheet.getLastRowNum();
		System.out.println(totalRowNum);
		for (int i = 1; i <= totalRowNum; i++) {
			// 获得第i行对象
			Row row = sheet.getRow(i);

			// 获得获得第i行第0列的 String类型对象

			HousesInfoMVO houses = new HousesInfoMVO();
			// 详细地址
			Cell cell = row.getCell((short) 1);
			houses.setHousesAddress(cell.getStringCellValue().trim());
			//产权人
			cell = row.getCell((short) 2);
			houses.setPropertyOwnerName(cell.getStringCellValue().trim());
			
			//产权人联系电话
			row.getCell((short) 3).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 3);
			houses.setPropertyOwnerTel(cell.getStringCellValue().trim());

			//产权证号
			cell = row.getCell((short) 4);
			houses.setPropertyCertificatesNumber(cell.getStringCellValue().trim());

			//房主身份证号	
			row.getCell((short) 6).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell(6);
			houses.setPropertyOwnerIdcard(cell.getStringCellValue().trim());
			
			//房主联系电话
			row.getCell((short) 7).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 7);
	
			
			//社区
			cell = row.getCell((short) 8);
			CommunityInfoMVO communityInfo = new CommunityInfoMVO();
			communityInfo.setCommunityName(cell.getStringCellValue().trim());
			communityInfo.setSts(STS_NORMAL);
			List<CommunityInfoMVO> cList = communityInfoMDAO.queryList(communityInfo);
			communityInfo = cList.get(0);
			houses.setCommunityId(communityInfo.getCommunityId());
			houses.setCommunityName(cell.getStringCellValue().trim());
			//省市区
			houses.setProvName(communityInfo.getProvName());
			houses.setProvCode(communityInfo.getProvCode());
			houses.setCityName(communityInfo.getCityName());
			houses.setCityCode(communityInfo.getCityCode());
			houses.setAreaName(communityInfo.getAreaName());
			houses.setAreaCode(communityInfo.getAreaCode());
			
			//小区
			cell = row.getCell((short) 9);
			CommunityStreetInfoMVO communityStreetInfo = new CommunityStreetInfoMVO();
			communityStreetInfo.setCommunityStreetName(cell.getStringCellValue().trim());
			communityStreetInfo.setSts(STS_NORMAL);
			List<CommunityStreetInfoMVO> scList = communityStreetInfoMDAO.queryList(communityStreetInfo);
			communityStreetInfo = scList.get(0);
			houses.setCommunityStreetId(communityStreetInfo.getCommunityStreetId());
			houses.setCommunityStreetName(cell.getStringCellValue().trim());
			
			//楼号
			row.getCell((short) 10).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 10);
			houses.setStoriedBuildingNumber(cell.getStringCellValue().trim());
			
			//单元
			row.getCell((short) 11).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 11);
			houses.setUnit(cell.getStringCellValue().trim());
			
			//门牌
			row.getCell((short) 12).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 12);
			houses.setHouseNumber(cell.getStringCellValue().trim());
			
			//户型
			cell = row.getCell((short) 13);
			houses.setHouseType(cell.getStringCellValue().trim());
			
			//房屋类型
			cell = row.getCell((short) 15);
			String housesTypeId = (String) CacheManager.getInstance().get("table.cache.idvalue.housestypeid", cell.getStringCellValue().trim());
			houses.setHousesTypeId(housesTypeId);
			houses.setHousesTypeName(cell.getStringCellValue().trim());
			
			//居住性质 自持/自持
			cell = row.getCell((short) 16);
			
			//租赁失效
			cell = row.getCell((short) 17);
			
			//首次上报时间
			cell = row.getCell((short) 18);
			houses.setCreateTime(cell.getStringCellValue().trim().replace("/", "-"));
			
			//最近上报时间
			cell = row.getCell((short) 19);
			houses.setUpdateTime(cell.getStringCellValue().trim().replace("/", "-"));
			
			houses.setHousesStatus(HousesInfo.houses_status_fangwu);
			houses.setSts(STS_NORMAL);
			list.add(houses);
		}

		for (String key : map.keySet()) {
			String[] tStrings = key.split("-");
			for (int i = 0; i <= list.size(); i++) {
				for (int t = 0; t < tStrings.length; t++) {
					if (tStrings[0].equals(Integer.valueOf(i + 1).toString())) {
						//房产证照片
						if (tStrings[1].equals("5")) {
							list.get(i).setPropertyCertificatesPhoto(map.get(key));
						}
						//户型图
						if (tStrings[1].equals("14")) {
							list.get(i).setHouseTypePhoto(map.get(key));
						}
					}

				}
			}

		}
		
		for(int i=0; i<list.size(); i++){
			housesInfoMDAO.insert(list.get(i));
		}
		return true;
	}


	@Override
	public boolean addMendianExcel(String filePath) throws Exception {
		Map<String, String> map = null;
		List<HousesInfoMVO> list = new ArrayList<HousesInfoMVO>();
		// 判断是否为excel类型文件
		if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
			System.out.println("文件不是excel类型");
		}
		//System.out.println(filePath);
		FileInputStream fis = null;
		Workbook wookbook = null;
		Sheet sheet = null;
		try {
			// 获取一个绝对地址的流
			fis = new FileInputStream(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (filePath.endsWith(".xls")) {
				// 2003版本的excel，用.xls结尾
				wookbook = new HSSFWorkbook(fis);
			}else if (filePath.endsWith(".xlsx")) {
				// 2007版本的excel，用.xlsx结尾
				wookbook = new XSSFWorkbook(fis);
			}
		} catch (Exception e) {
			logger.info("导入excel出错", e);
		}
		
		Map<String, PictureData> maplist = null;
	
		sheet = wookbook.getSheetAt(0);
		
		// 判断用07还是03的方法获取图片
		if (filePath.endsWith(".xls")) {
			maplist = getPictures1((HSSFSheet) sheet);
		} else if (filePath.endsWith(".xlsx")) {
			maplist = getPictures2((XSSFSheet) sheet);
		}
		try {
			map = printImg(maplist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 得到一个工作表

		// 获得表头
		/*Row rowHead = sheet.getRow(0);

		// 判断表头是否正确
		System.out.println(rowHead.getPhysicalNumberOfCells());
		if (rowHead.getPhysicalNumberOfCells() != 8) {
			System.out.println("表头的数量不对!");
		}*/

		// 获得数据的总行数
		int totalRowNum = sheet.getLastRowNum();
		System.out.println(totalRowNum);
		for (int i = 1; i <= totalRowNum; i++) {
			// 获得第i行对象
			Row row = sheet.getRow(i);

			// 获得获得第i行第0列的 String类型对象

			HousesInfoMVO houses = new HousesInfoMVO();
			// 详细地址
			Cell cell = row.getCell((short) 1);
			houses.setHousesAddress(cell.getStringCellValue().trim());
			//产权人
			cell = row.getCell((short) 2);
			houses.setPropertyOwnerName(cell.getStringCellValue().trim());
			
			//产权人联系电话
			row.getCell((short) 3).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 3);
			houses.setPropertyOwnerTel(cell.getStringCellValue().trim());

			//产权证号
			cell = row.getCell((short) 4);
			houses.setPropertyCertificatesNumber(cell.getStringCellValue().trim());

			//店主
			row.getCell((short) 6).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell(6);
			houses.setPropertyOwnerIdcard(cell.getStringCellValue().trim());
			
			//店主联系电话
			row.getCell((short) 7).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 7);
			
			//社区
			cell = row.getCell((short) 8);
			CommunityInfoMVO communityInfo = new CommunityInfoMVO();
			communityInfo.setCommunityName(cell.getStringCellValue().trim());
			communityInfo.setSts(STS_NORMAL);
			List<CommunityInfoMVO> cList = communityInfoMDAO.queryList(communityInfo);
			communityInfo = cList.get(0);
			houses.setCommunityId(communityInfo.getCommunityId());
			houses.setCommunityName(cell.getStringCellValue().trim());
			
			//小区
			cell = row.getCell((short) 9);
			CommunityStreetInfoMVO communityStreetInfo = new CommunityStreetInfoMVO();
			communityStreetInfo.setCommunityStreetName(cell.getStringCellValue().trim());
			communityStreetInfo.setSts(STS_NORMAL);
			List<CommunityStreetInfoMVO> scList = communityStreetInfoMDAO.queryList(communityStreetInfo);
			communityStreetInfo = scList.get(0);
			houses.setCommunityStreetId(communityStreetInfo.getCommunityStreetId());
			houses.setCommunityStreetName(cell.getStringCellValue().trim());
			
			//内/外铺
			row.getCell((short) 10).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 10);
			if (cell.getStringCellValue().trim().equals("内铺")) {
				houses.setStoreLocation("1");
			}else if (cell.getStringCellValue().trim().equals("外铺")) {
				houses.setStoreLocation("2");
			}
			
			//单元
			row.getCell((short) 11).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 11);
			houses.setUnit(cell.getStringCellValue().trim());
			
			//门牌
			row.getCell((short) 12).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 12);
			houses.setHouseNumber(cell.getStringCellValue().trim());
			
			//户型
			cell = row.getCell((short) 13);
			houses.setHouseType(cell.getStringCellValue().trim());
			
			//房屋类型
			cell = row.getCell((short) 15);
			String housesTypeId = (String) CacheManager.getInstance().get("table.cache.idvalue.housestypeid", cell.getStringCellValue().trim());
			houses.setHousesTypeId(housesTypeId);
			houses.setHousesTypeName(cell.getStringCellValue().trim());
			
			//居住性质 自持/自持
			cell = row.getCell((short) 16);
			
			//租赁失效
			cell = row.getCell((short) 17);
			
			//首次上报时间
			cell = row.getCell((short) 18);
			houses.setCreateTime(cell.getStringCellValue().trim().replace("/", "-"));
			
			//最近上报时间
			cell = row.getCell((short) 19);
			houses.setUpdateTime(cell.getStringCellValue().trim().replace("/", "-"));
			
			houses.setSts(STS_NORMAL);
			list.add(houses);
		}

		for (String key : map.keySet()) {
			String[] tStrings = key.split("-");
			for (int i = 0; i <= list.size(); i++) {
				for (int t = 0; t < tStrings.length; t++) {
					if (tStrings[0].equals(Integer.valueOf(i + 1).toString())) {
						//房产证照片
						if (tStrings[1].equals("5")) {
							list.get(i).setPropertyCertificatesPhoto(map.get(key));
						}
						//户型图
						if (tStrings[1].equals("14")) {
							list.get(i).setHouseTypePhoto(map.get(key));
						}
					}

				}
			}

		}
		
		for(int i=0; i<list.size(); i++){
			housesInfoMDAO.insert(list.get(i));
		}
		return true;
	}
	
	@Override
	public boolean addPersonnelExcel(String filePath) throws SysException, AppException, Exception {
		Map<String, String> map = null;
		List<PersonnelInfoMVO> list = new ArrayList<PersonnelInfoMVO>();
		// 判断是否为excel类型文件
		if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
			System.out.println("文件不是excel类型");
		}
		//System.out.println(filePath);
		FileInputStream fis = null;
		Workbook wookbook = null;
		Sheet sheet = null;
		try {
			// 获取一个绝对地址的流
			fis = new FileInputStream(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (filePath.endsWith(".xls")) {
				// 2003版本的excel，用.xls结尾
				wookbook = new HSSFWorkbook(fis);
			}else if (filePath.endsWith(".xlsx")) {
				// 2007版本的excel，用.xlsx结尾
				wookbook = new XSSFWorkbook(fis);
			}
		} catch (Exception e) {
			logger.info("导入excel出错", e);
		}
		
		Map<String, PictureData> maplist = null;
	
		sheet = wookbook.getSheetAt(0);
		
		// 判断用07还是03的方法获取图片
		if (filePath.endsWith(".xls")) {
			maplist = getPictures1((HSSFSheet) sheet);
		} else if (filePath.endsWith(".xlsx")) {
			maplist = getPictures2((XSSFSheet) sheet);
		}
		try {
			map = printImg(maplist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 得到一个工作表

		// 获得表头
		/*Row rowHead = sheet.getRow(0);

		// 判断表头是否正确
		System.out.println(rowHead.getPhysicalNumberOfCells());
		if (rowHead.getPhysicalNumberOfCells() != 8) {
			System.out.println("表头的数量不对!");
		}*/

		// 获得数据的总行数
		int totalRowNum = sheet.getLastRowNum();
		System.out.println(totalRowNum);
		for (int i = 1; i <= totalRowNum; i++) {
			// 获得第i行对象
			Row row = sheet.getRow(i);

			// 获得获得第i行第0列的 String类型对象

			PersonnelInfoMVO per = new PersonnelInfoMVO();
			// 
			Cell cell = row.getCell((short) 1);
			per.setUsername(cell.getStringCellValue());
			
			cell = row.getCell((short) 2);
			if (cell.getStringCellValue().trim().equals("男")) {
				per.setGender("1");
			}else if (cell.getStringCellValue().trim().equals("女")) {
				per.setGender("2");
			}
			
			//民族
			cell = row.getCell((short) 3);
			per.setNationName(cell.getStringCellValue().trim());
			String nationId = (String) CacheManager.getInstance().get("table.cache.idvalue.nationid", cell.getStringCellValue().trim());
			per.setNationId(nationId);

			//出生日期
			cell = row.getCell((short) 5);
			per.setBirthDate(cell.getStringCellValue().trim().replace("/", "-"));

			//联系电话
			row.getCell((short) 6).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell(6);
			per.setTelephone(cell.getStringCellValue().trim());
			
			//证件类型
			cell = row.getCell((short) 7);
			per.setCertificatesTypeId("1");
			per.setCertificatesTypeName(cell.getStringCellValue().trim());
			
			//证件号码
			cell = row.getCell((short) 8);
			per.setCertificatesNumber(cell.getStringCellValue().trim());
			
			//证件有效期
			cell = row.getCell((short) 11);
			String certStartTime = StringUtils.substringBefore(cell.getStringCellValue().trim(), "-").replace("/", "-");
			String certStopTime = StringUtils.substringAfter(cell.getStringCellValue().trim(), "-").replace("/", "-");
			per.setCertificatesStartTime(certStartTime);
			per.setCertificatesStopTime(certStopTime);
			
			//证件地址
			cell = row.getCell((short) 12);
			per.setCertificatesAddress(cell.getStringCellValue().trim());
			
			//证件机关
			cell = row.getCell((short) 13);
			per.setCertificatesOffice(cell.getStringCellValue().trim());
			
			//关联房产
			row.getCell((short) 14).setCellType(Cell.CELL_TYPE_STRING);
			cell = row.getCell((short) 14);
			HousesInfoMVO housesInfo = new HousesInfoMVO();
			housesInfo.setPropertyCertificatesNumber(cell.getStringCellValue().trim());
			housesInfo.setSts(STS_NORMAL);
			List<HousesInfoMVO> hList = housesInfoMDAO.queryList(housesInfo);
			//如果找不到对应的房产，不插入此条数据
			if (hList.size() > 0) {
				housesInfo = hList.get(0);
				per.setHousesId(housesInfo.getHousesId());
			}else {
				continue;
			}
			
			//居住类型
			cell = row.getCell((short) 15);
			String liveTypeId = (String) CacheManager.getInstance().get("table.cache.idvalue.livetypeid", cell.getStringCellValue().trim());
			per.setLiveTypeId(liveTypeId);
			per.setLiveTypeName(cell.getStringCellValue().trim());
			if (liveTypeId.equals("1") || liveTypeId.equals("2") || liveTypeId.equals("7")) {
				per.setLeaseMode(PersonnelInfo.lease_mode_changqi);
			}else {
				per.setLeaseMode(PersonnelInfo.lease_mode_youxiaoqi);
			}
			if (liveTypeId.equals("1") || liveTypeId.equals("2") || liveTypeId.equals("3") || liveTypeId.equals("4")) {
				per.setPerSort(PersonnelInfo.per_sort_app);
			}else {
				per.setPerSort(PersonnelInfo.per_sort_not_app);
			}
			
			//首次上报时间
			cell = row.getCell((short) 16);
			per.setCreateTime(cell.getStringCellValue().trim().replace("/", "-"));
			
			//最近上报时间
			cell = row.getCell((short) 17);
			per.setUpdateTime(cell.getStringCellValue().trim().replace("/", "-"));
			
			per.setStatus(PersonnelInfo.status_passed);
			per.setSts(STS_NORMAL);
			list.add(per);
		}

		for (String key : map.keySet()) {
			String[] tStrings = key.split("-");
			for (int i = 0; i <= list.size(); i++) {
				for (int t = 0; t < tStrings.length; t++) {
					if (tStrings[0].equals(Integer.valueOf(i + 1).toString())) {
						//人脸照片
						if (tStrings[1].equals("4")) {
							list.get(i).setFacePhoto(map.get(key));
						}
						//证件正面
						if (tStrings[1].equals("9")) {
							list.get(i).setCertificatesPositivePhoto(map.get(key));
						}
						//证件反面
						if (tStrings[1].equals("10")) {
							list.get(i).setCertificatesNegativePhoto(map.get(key));
						}
					}

				}
			}

		}
		
		for(int i=0; i<list.size(); i++){
			personnelInfoMDAO.insert(list.get(i));
		}
		return true;
	}
	
	
	/**
	 * 获取图片和位置 (xls)
	 * 
	 * @param sheet
	 * @return
	 * @throws IOException
	 */
	public static Map<String, PictureData> getPictures1(HSSFSheet sheet) throws IOException {
		Map<String, PictureData> map = new HashMap<String, PictureData>();
		List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
		for (HSSFShape shape : list) {
			if (shape instanceof HSSFPicture) {
				HSSFPicture picture = (HSSFPicture) shape;
				HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
				PictureData pdata = picture.getPictureData();
				String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // 行号-列号

				map.put(key, pdata);
			}
		}
		return map;
	}

	/**
	 * 获取图片和位置 (xlsx)
	 * 
	 * @param sheet
	 * @return
	 * @throws IOException
	 */
	public static Map<String, PictureData> getPictures2(XSSFSheet sheet) throws IOException {
		Map<String, PictureData> map = new HashMap<String, PictureData>();
		List<POIXMLDocumentPart> list = sheet.getRelations();
		for (POIXMLDocumentPart part : list) {
			if (part instanceof XSSFDrawing) {
				XSSFDrawing drawing = (XSSFDrawing) part;
				List<XSSFShape> shapes = drawing.getShapes();
				for (XSSFShape shape : shapes) {
					XSSFPicture picture = (XSSFPicture) shape;
					XSSFClientAnchor anchor = picture.getPreferredSize();
					CTMarker marker = anchor.getFrom();
					String key = marker.getRow() + "-" + marker.getCol();
					map.put(key, picture.getPictureData());
				}
			}
		}
		return map;
	}

	// 图片写出
	public static Map<String, String> printImg(Map<String, PictureData> sheetList) throws IOException {
		Map<String, String> pa = new HashMap<String, String>();
		// for (Map<String, PictureData> map : sheetList) {
		Object key[] = sheetList.keySet().toArray();
		for (int i = 0; i < sheetList.size(); i++) {
			// 获取图片流
			PictureData pic = sheetList.get(key[i]);
			// 获取图片索引
			String picName = key[i].toString();
			// 获取图片格式
			String ext = pic.suggestFileExtension();

			byte[] data = pic.getData();

			
			// 创建日期目录
			String fileDir = DataFileUtil.getWebappRoot() + Constant.UPLOAD_IMPROT_IMAGE_DIR + DateUtil.now("yyyyMMdd");
			File dir = new File(fileDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 图片保存路径
			String relativePath = Constant.UPLOAD_IMPROT_IMAGE_DIR + DateUtil.now("yyyyMMdd");
			String fileName = ApiUtil.uuid() + "." + ext;
			String savePath = DataFileUtil.getWebappRoot() + "/" + relativePath + "/" + fileName;
			FileOutputStream out = new FileOutputStream(savePath);
			String path = "/jianfuzengxiao/" + relativePath + "/" + fileName;
			pa.put(picName, path);
			out.write(data);
			out.close();
		}
		return pa;

		// }

	}



}
