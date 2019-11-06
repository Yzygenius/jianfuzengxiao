package com.jianfuzengxiao.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import com.bamboo.framework.common.util.DateUtil;
import com.jianfuzengxiao.base.common.Constant;
import com.jianfuzengxiao.base.common.DataFileUtil;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;

public class Upxml {

	public static List<HousesInfoMVO> getDataFromExcel(String filePath) throws IOException {
		Map<String, String> map = null;
		List<HousesInfoMVO> list = new ArrayList<HousesInfoMVO>();
		// 判断是否为excel类型文件
		if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
			System.out.println("文件不是excel类型");
		}

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
			// 2003版本的excel，用.xls结尾
			wookbook = new HSSFWorkbook(fis);// 得到工作簿

		} catch (Exception ex) {
			// ex.printStackTrace();
			try {
				// 2007版本的excel，用.xlsx结尾
				fis = new FileInputStream(filePath);
				// wookbook = new XSSFWorkbook(fis);//得到工作簿
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		for (int i = 1; i <= totalRowNum; i++) {
			// 获得第i行对象
			Row row = sheet.getRow(i);

			// 获得获得第i行第0列的 String类型对象

			HousesInfoMVO ub = new HousesInfoMVO();
			// 
			Cell cell = row.getCell((short) 1);
			String housesStatus = "0";
			if (cell.getStringCellValue().equals("房屋") && (cell.getStringCellValue() != null || cell.getStringCellValue() != "")) {
				housesStatus = "1";
			}else if (cell.getStringCellValue().equals("门店") && (cell.getStringCellValue() != null || cell.getStringCellValue() != "")) {
				housesStatus = "2";
			}
			ub.setHousesStatus(housesStatus);

			cell = row.getCell((short) 2);
			ub.setPropertyOwnerName(cell.getStringCellValue());

			cell = row.getCell((short) 3);
			ub.setPropertyOwnerTel(cell.getStringCellValue());

			cell = row.getCell((short) 4);
			ub.setPropertyOwnerIdcard(cell.getStringCellValue());

			cell = row.getCell((short) 5);
			ub.setPropertyCertificatesNumber(cell.getStringCellValue());

			cell = row.getCell((short) 6);
			ub.setCommunityName(cell.getStringCellValue());
			
			cell = row.getCell((short) 7);
			ub.setCommunityStreetName(cell.getStringCellValue());
			
			cell = row.getCell((short) 8);
			ub.setHouseType(cell.getStringCellValue());
			
			cell = row.getCell((short) 9);
			ub.setStoriedBuildingNumber(cell.getStringCellValue());
			
			cell = row.getCell((short) 10);
			ub.setUnit(cell.getStringCellValue());
			
			cell = row.getCell((short) 11);
			ub.setHouseNumber(cell.getStringCellValue());
			
			cell = row.getCell((short) 12);
			ub.setHousesAddress(cell.getStringCellValue());
			
			cell = row.getCell((short) 13);
			ub.setHousesTypeName(cell.getStringCellValue());
			
			cell = row.getCell((short) 14);
			String storeLocation = "";
			if (cell.getStringCellValue().equals("内铺") && (cell.getStringCellValue() != null || cell.getStringCellValue() != "")) {
				storeLocation = "1";
			}else if (cell.getStringCellValue().equals("外铺") && (cell.getStringCellValue() != null || cell.getStringCellValue() != "")) {
				storeLocation = "2";
			}
			ub.setStoreLocation(storeLocation);
			
			cell = row.getCell((short) 15);
			ub.setProvName(cell.getStringCellValue());
			
			cell = row.getCell((short) 16);
			ub.setCityName(cell.getStringCellValue());
			
			cell = row.getCell((short) 17);
			ub.setAreaName(cell.getStringCellValue());
			
			list.add(ub);
		}

		for (String key : map.keySet()) {
			String[] tStrings = key.split("-");
			for (int i = 0; i <= list.size(); i++) {
				for (int t = 0; t < tStrings.length; t++) {
					if (tStrings[0].equals(Integer.valueOf(i + 1).toString())) {
						if (tStrings[1].equals("20")) {
							list.get(i).setPropertyCertificatesPhoto(map.get(key));
						}
						if (tStrings[1].equals("21")) {
							list.get(i).setHouseTypePhoto(map.get(key));
						}
					}

				}
			}

		}
		return list;
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

	public static void main(String[] args) throws Exception {

	}
}