package com.jianfuzengxiao.base.common;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bamboo.framework.common.util.DateUtil;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.spring.SpringHelper;
import com.jianfuzengxiao.base.utils.ApiUtil;
import com.jianfuzengxiao.pub.entity.AttachFile;
import com.jianfuzengxiao.pub.entity.AttachFileMVO;
import com.jianfuzengxiao.pub.service.IAttachFileService;

public class DataFileUtil {
	private static Logger logger = LoggerFactory.getLogger(DataFileUtil.class);
	public final static String DATA_DIR = "data/";
	public final static String ATTACH_IMAGE_DIR = "data/attach/images/";
	public final static String ATTACH_FILE_DIR = "data/attach/files/";
	public final static String ATTACH_EXCEL_DIR = "data/attach/excel/";
	
	/**
	 * 保存上传图片到目标文件夹
	 * @param imgFile
	 * @param saveDb
	 * @return
	 */
	public static AttachFileMVO saveDBImage(CommonsMultipartFile imgFile) {
		// 保存路径
		String relativePath = ATTACH_EXCEL_DIR + DateUtil.now("yyyyMMdd");
		String path = getWebappRoot() + "/" + relativePath;
		File imgDir = new File(path);
		if (!imgDir.exists()) {
			imgDir.mkdirs();
		}
		
		// 文件名
		String uuid = ApiUtil.uuid();
		String filename = uuid + "." + FileUtil.getExtName(imgFile.getOriginalFilename());
		logger.debug("生成文件名：" + filename);
		File file = new File(imgDir, filename);
		
		// 保存到目标文件夹
		try (FileOutputStream outputStream = new FileOutputStream(file)){
			IOUtils.copy(imgFile.getInputStream(), outputStream);
		} catch (Exception e) {
		}
		String filepath = relativePath + "/" + file.getName();
		
		// 保存到数据库
		IAttachFileService attachFileService = SpringHelper.getBean(IAttachFileService.class);
		AttachFileMVO attach = new AttachFileMVO();
		attach.setFileId(uuid);
		attach.setFileType(AttachFile.TYPE_IMAGE);
		attach.setFileName(filename);
		attach.setSaveName(filepath);
		attach.setState(AttachFile.STATE_TEMP);
		attach.setSts("A");
		attach.setCreateTime(DateUtil.nowTime());
		try {
			attachFileService.insert(attach);
		} catch (AppException e) {
			throw new SysException(e.getErrId(), e.getErrMsg(), new Exception(e.getCause()));
		}
		return attach;
	}
	
	public static String getWebappRoot() {
		return System.getProperty("jianfuzengxiao.root");
	}

}
