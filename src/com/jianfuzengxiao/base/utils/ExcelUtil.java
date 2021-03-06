package com.jianfuzengxiao.base.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jianfuzengxiao.base.common.FileUtil;
import com.jianfuzengxiao.pub.entity.HousesInfoMVO;
import com.jianfuzengxiao.pub.entity.PersonnelInfoMVO;

public class ExcelUtil {

	private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	/**
	 * 导出Excel（样品）
	 * 
	 * @param sheetName
	 *            sheet名称
	 * @param title
	 *            标题
	 * @param values
	 *            内容
	 * @param wb
	 *            HSSFWorkbook对象
	 * @return
	 */
	public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, List<HousesInfoMVO> list,
			HSSFWorkbook wb) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}

		// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 650);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 声明列对象
		HSSFCell cell = null;

		// 创建标题
		for (int i = 0; i < title.length; i++) {
			sheet.setColumnWidth(i, 6000);
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			HSSFFont font = wb.createFont();
			font.setFontName("黑体");
			font.setFontHeightInPoints((short) 15);// 设置字体大小
			style.setFont(font);
			cell.setCellStyle(style);
		}
		BufferedImage bufferImg = null;// 图片一
		BufferedImage bufferImg2 = null;// 图片二
		try {
			// 创建内容
			HSSFCellStyle styleCon = wb.createCellStyle();
			styleCon.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			styleCon.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
				row.setHeight((short) 550);
				HousesInfoMVO keeSpecimen = list.get(i);
				// 将内容按顺序赋给对应的列对象
				ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
				
				HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
				
				String fangchanzheng = "";
				if (keeSpecimen.getPropertyCertificatesPhoto() == null || keeSpecimen.getPropertyCertificatesPhoto().equals("")) {
					logger.info("excel导出房产证图片找不到："+keeSpecimen.getPropertyCertificatesPhoto());
				} else {
					fangchanzheng = request.getSession().getServletContext().getRealPath(keeSpecimen.getPropertyCertificatesPhoto().replace("/jianfuzengxiao", ""));
					
					if (new File(fangchanzheng).exists()) {
						bufferImg = ImageIO.read(new File(fangchanzheng));
						ImageIO.write(bufferImg, FileUtil.getExtName(fangchanzheng), byteArrayOut);
						// 图片一导出到单元格B2中
						HSSFClientAnchor anchor = new HSSFClientAnchor(480, 30, 700, 250, (short) 23, i + 1, (short) 23,
								i + 1);
						// 插入图片
						patriarch.createPicture(anchor,
								wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
					}
				}
				
				ByteArrayOutputStream byteArrayOut2 = new ByteArrayOutputStream();
				HSSFPatriarch patriarch2 = sheet.createDrawingPatriarch();
				String huxingtu = "";
				if (keeSpecimen.getHouseTypePhoto() == null || keeSpecimen.getHouseTypePhoto().equals("")) {
					logger.info("excel导出户型图片找不到："+keeSpecimen.getHouseTypePhoto());
				} else {
					huxingtu = request.getSession().getServletContext().getRealPath(keeSpecimen.getHouseTypePhoto().replace("/jianfuzengxiao", ""));
					
					if (new File(huxingtu).exists()) {
						bufferImg2 = ImageIO.read(new File(huxingtu));
						ImageIO.write(bufferImg2, FileUtil.getExtName(huxingtu), byteArrayOut2);
						// 图片一导出到单元格B2中
						HSSFClientAnchor anchor = new HSSFClientAnchor(480, 30, 700, 250, (short) 24, i + 1, (short) 24,
								i + 1);
						// 插入图片
						patriarch2.createPicture(anchor,
								wb.addPicture(byteArrayOut2.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
					}
				}
				

				String housesStatus = "";
				if (keeSpecimen.getHousesStatus().equals("1")) {
					housesStatus = "房屋";
				}else if (keeSpecimen.getHousesStatus().equals("2")) {
					housesStatus = "门店";
				}
				String storeLocation = "";
				if (keeSpecimen.getStoreLocation() != null && keeSpecimen.getStoreLocation().equals("1")) {
					storeLocation = "内铺";
				}else if (keeSpecimen.getStoreLocation() != null && keeSpecimen.getStoreLocation().equals("2")) {
					storeLocation = "外铺";
				}
				cell = row.createCell(0);
				cell.setCellValue(keeSpecimen.getHousesId());
				cell.setCellStyle(styleCon);
				/*cell = row.createCell(1);
				cell.setCellValue(keeSpecimen.getAdminId());
				cell.setCellStyle(styleCon);*/
				cell = row.createCell(1);
				cell.setCellValue(housesStatus);
				cell.setCellStyle(styleCon);
				cell = row.createCell(2);
				cell.setCellValue(keeSpecimen.getProvName());
				cell.setCellStyle(styleCon);
				cell = row.createCell(3);
				cell.setCellValue(keeSpecimen.getCityName());
				cell.setCellStyle(styleCon);
				cell = row.createCell(4);
				cell.setCellValue(keeSpecimen.getAreaName());
				cell.setCellStyle(styleCon);
				cell = row.createCell(5);
				cell.setCellValue(keeSpecimen.getGwhName());
				cell.setCellStyle(styleCon);
				cell = row.createCell(6);
				cell.setCellValue(keeSpecimen.getCommunityName());
				cell.setCellStyle(styleCon);
				cell = row.createCell(7);
				cell.setCellValue(keeSpecimen.getCommunityStreetName());
				cell.setCellStyle(styleCon);
				cell = row.createCell(8);
				cell.setCellValue(storeLocation);
				cell.setCellStyle(styleCon);
				cell = row.createCell(9);
				cell.setCellValue(keeSpecimen.getStoriedBuildingNumber());
				cell.setCellStyle(styleCon);
				cell = row.createCell(10);
				cell.setCellValue(keeSpecimen.getUnit());
				cell.setCellStyle(styleCon);
				cell = row.createCell(11);
				cell.setCellValue(keeSpecimen.getHouseNumber());
				cell.setCellStyle(styleCon);
				cell = row.createCell(12);
				cell.setCellValue(keeSpecimen.getHousesAddress());
				cell.setCellStyle(styleCon);
				cell = row.createCell(13);
				cell.setCellValue(keeSpecimen.getHouseType());
				cell.setCellStyle(styleCon);
				cell = row.createCell(14);
				cell.setCellValue(keeSpecimen.getHousesTypeName());
				cell.setCellStyle(styleCon);
				cell = row.createCell(15);
				cell.setCellValue(keeSpecimen.getFangzhu());
				cell.setCellStyle(styleCon);
				cell = row.createCell(16);
				cell.setCellValue(keeSpecimen.getFangzhuTel());
				cell.setCellStyle(styleCon);
				cell = row.createCell(17);
				cell.setCellValue(keeSpecimen.getPropertyOwnerName());
				cell.setCellStyle(styleCon);
				cell = row.createCell(18);
				cell.setCellValue(keeSpecimen.getPropertyOwnerTel());
				cell.setCellStyle(styleCon);
				cell = row.createCell(19);
				cell.setCellValue(keeSpecimen.getPropertyOwnerIdcard());
				cell.setCellStyle(styleCon);
				cell = row.createCell(20);
				cell.setCellValue(keeSpecimen.getPropertyCertificatesNumber());
				cell.setCellStyle(styleCon);
				cell = row.createCell(21);
				cell.setCellValue(keeSpecimen.getCreateTime());
				cell.setCellStyle(styleCon);
				cell = row.createCell(22);
				cell.setCellValue(keeSpecimen.getUpdateTime());
				cell.setCellStyle(styleCon);
			}
			
			return wb;
		} catch (Exception e) {
			logger.info("导出excel错误：", e);
		}
		return wb;
	}

	public static HSSFWorkbook getHSSFWorkbookPer(String sheetName, String[] title, List<PersonnelInfoMVO> list,
			HSSFWorkbook wb) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}

		// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 650);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 声明列对象
		HSSFCell cell = null;

		// 创建标题
		for (int i = 0; i < title.length; i++) {
			sheet.setColumnWidth(i, 6000);
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			HSSFFont font = wb.createFont();
			font.setFontName("黑体");
			font.setFontHeightInPoints((short) 15);// 设置字体大小
			style.setFont(font);
			cell.setCellStyle(style);
		}
		BufferedImage bufferImg = null;// 图片一
		BufferedImage bufferImg2 = null;// 图片二
		BufferedImage bufferImg3 = null;// 图片3
		try {
			// 创建内容
			HSSFCellStyle styleCon = wb.createCellStyle();
			styleCon.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			styleCon.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
				row.setHeight((short) 550);
				PersonnelInfoMVO keeSpecimen = list.get(i);
				// 将内容按顺序赋给对应的列对象
				ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
				HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
				String facePhoto = "";
				if (keeSpecimen.getFacePhoto() == null || keeSpecimen.getFacePhoto().equals("")) {
					logger.info("excel导出人脸照片图片找不到："+keeSpecimen.getFacePhoto());
				} else {
					facePhoto = request.getSession().getServletContext().getRealPath(keeSpecimen.getFacePhoto().replace("/jianfuzengxiao", ""));
					
					if (new File(facePhoto).exists()) {
						bufferImg = ImageIO.read(new File(facePhoto));
						ImageIO.write(bufferImg, FileUtil.getExtName(facePhoto), byteArrayOut);
						// 图片一导出到单元格B2中
						HSSFClientAnchor anchor = new HSSFClientAnchor(480, 30, 700, 250, (short) 11, i + 1, (short) 11,
								i + 1);
						// 插入图片
						patriarch.createPicture(anchor,
								wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
					}
				}
				
				ByteArrayOutputStream byteArrayOut2 = new ByteArrayOutputStream();
				HSSFPatriarch patriarch2 = sheet.createDrawingPatriarch();
				String certPositivePhoto = "";
				if (keeSpecimen.getCertificatesPositivePhoto() == null || keeSpecimen.getCertificatesPositivePhoto().equals("")) {
					logger.info("excel导出证件正面照片找不到："+keeSpecimen.getCertificatesPositivePhoto());
				} else {
					certPositivePhoto = request.getSession().getServletContext().getRealPath(keeSpecimen.getCertificatesPositivePhoto().replace("/jianfuzengxiao", ""));
					
					if (new File(certPositivePhoto).exists()) {
						bufferImg2 = ImageIO.read(new File(certPositivePhoto));
						ImageIO.write(bufferImg2, FileUtil.getExtName(certPositivePhoto), byteArrayOut2);
						// 图片一导出到单元格B2中
						HSSFClientAnchor anchor = new HSSFClientAnchor(480, 30, 700, 250, (short) 12, i + 1, (short) 12,
								i + 1);
						// 插入图片
						patriarch2.createPicture(anchor,
								wb.addPicture(byteArrayOut2.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
					}
				}
				
				ByteArrayOutputStream byteArrayOut3 = new ByteArrayOutputStream();
				HSSFPatriarch patriarch3 = sheet.createDrawingPatriarch();
				String certNegativePhoto = "";
				if (keeSpecimen.getCertificatesNegativePhoto() == null || keeSpecimen.getCertificatesNegativePhoto().equals("")) {
					logger.info("excel导出证件反面照片找不到："+keeSpecimen.getCertificatesNegativePhoto());
				} else {
					certNegativePhoto = request.getSession().getServletContext().getRealPath(keeSpecimen.getCertificatesNegativePhoto().replace("/jianfuzengxiao", ""));
					
					if (new File(certNegativePhoto).exists()) {
						bufferImg3 = ImageIO.read(new File(certNegativePhoto));
						ImageIO.write(bufferImg3, FileUtil.getExtName(certNegativePhoto), byteArrayOut3);
						// 图片一导出到单元格B2中
						HSSFClientAnchor anchor = new HSSFClientAnchor(480, 30, 700, 250, (short) 13, i + 1, (short) 13,
								i + 1);
						// 插入图片
						patriarch3.createPicture(anchor,
								wb.addPicture(byteArrayOut3.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
					}
				}
				
				
				String gender = "";
				if (keeSpecimen.getGender().equals("1")) {
					gender = "男";
				}else if (keeSpecimen.getGender().equals("2")) {
					gender = "女";
				}
				String status = "";
				if (keeSpecimen.getStatus().equals("1")) {
					status = "待审核";
				}else if (keeSpecimen.getStatus().equals("2")) {
					status = "通过审核";
				}else if (keeSpecimen.getStatus().equals("3")) {
					status = "未通过审核";
				}
				if (keeSpecimen.getSts().equals("P")) {
					status = "已注销";
				}
				cell = row.createCell(0);
				cell.setCellValue(keeSpecimen.getUsername());//姓名
				cell.setCellStyle(styleCon);
				cell = row.createCell(1);
				cell.setCellValue(gender);//性别
				cell.setCellStyle(styleCon);
				cell = row.createCell(2);
				cell.setCellValue(keeSpecimen.getBirthDate());//出生日期
				cell.setCellStyle(styleCon);
				cell = row.createCell(3);
				cell.setCellValue(keeSpecimen.getNationName());//民族
				cell.setCellStyle(styleCon);
				cell = row.createCell(4);
				cell.setCellValue(keeSpecimen.getTelephone());//联系电话
				cell.setCellStyle(styleCon);
				cell = row.createCell(5);
				cell.setCellValue(keeSpecimen.getCertificatesNumber());//身份证号
				cell.setCellStyle(styleCon);
				cell = row.createCell(6);
				cell.setCellValue(keeSpecimen.getCertificatesStartTime()+" - "+keeSpecimen.getCertificatesStopTime());//证件时效
				cell.setCellStyle(styleCon);
				cell = row.createCell(7);
				cell.setCellValue(keeSpecimen.getCertificatesAddress());//证件地址
				cell.setCellStyle(styleCon);
				cell = row.createCell(8);
				cell.setCellValue(keeSpecimen.getCertificatesOffice());//办证机关
				cell.setCellStyle(styleCon);
				cell = row.createCell(9);
				cell.setCellValue(status);//审核状态
				cell.setCellStyle(styleCon);
				cell = row.createCell(10);
				cell.setCellValue(keeSpecimen.getUpdateTime());//最新上报时间
				cell.setCellStyle(styleCon);
				cell = row.createCell(14);
				cell.setCellValue(keeSpecimen.getCommunityName()+keeSpecimen.getCommunityStreetName()+keeSpecimen.getStoriedBuildingNumber()+keeSpecimen.getUnit()+keeSpecimen.getHouseNumber());//居住地址
				cell.setCellStyle(styleCon);
				cell = row.createCell(15);
				cell.setCellValue(keeSpecimen.getHousesAddress());//详细地址
				cell.setCellStyle(styleCon);
				cell = row.createCell(16);
				cell.setCellValue(keeSpecimen.getPropertyOwnerName());//产权人
				cell.setCellStyle(styleCon);
				cell = row.createCell(17);
				cell.setCellValue(keeSpecimen.getHousesTypeName());//房屋类型
				cell.setCellStyle(styleCon);
				cell = row.createCell(18);
				cell.setCellValue(keeSpecimen.getHouseType());//房屋户型
				cell.setCellStyle(styleCon);
				cell = row.createCell(19);
				cell.setCellValue(keeSpecimen.getLiveTypeName());//居住类型
				cell.setCellStyle(styleCon);
				cell = row.createCell(20);
				cell.setCellValue(keeSpecimen.getLeaseStartTime());//居住开始时间
				cell.setCellStyle(styleCon);
				cell = row.createCell(21);
				cell.setCellValue(keeSpecimen.getLeaseDay());//居住时长
				cell.setCellStyle(styleCon);
			}
			
			return wb;
		} catch (Exception e) {
			logger.info("导出excel错误：", e);
		}
		return wb;
	}
}
