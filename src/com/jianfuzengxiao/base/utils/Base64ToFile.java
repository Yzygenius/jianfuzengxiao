package com.jianfuzengxiao.base.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.bamboo.framework.common.util.DateUtil;
import com.jianfuzengxiao.base.common.Constant;
import com.jianfuzengxiao.base.common.DataFileUtil;
import com.jianfuzengxiao.base.common.RC;

import sun.misc.BASE64Decoder;

public class Base64ToFile {

	public static Map<String, String> base64ToFile(String base64, String type) throws Exception {
		String uploadImgDir = "";
		switch (type) {
		case "A":
			uploadImgDir = Constant.UPLOAD_FACE_IMAGE_DIR;
			break;
		case "B":
			uploadImgDir = Constant.UPLOAD_CERT_IMAGE_DIR;
			break;
		case "C":
			uploadImgDir = Constant.UPLOAD_LEASE_CONTRACT_IMAGE_DIR;
			break;
		case "Z":
			uploadImgDir = Constant.UPLOAD_OTHER_IMAGE_DIR;
			break;
		//default:
			//return apiResult(RC.OTHER_CZ_ERROR);
		}
		Map<String, String> map = new HashMap<String, String>();
		if(base64.contains("data:image")){
			base64 = base64.substring(base64.indexOf(",")+1);
		}
		base64 = base64.toString().replace("\r\n", "");
		File file = null;
		
		String fileName = ApiUtil.uuid() + ".png";
		//创建文件目录
		String day = DateUtil.now("yyyyMMdd");
		String relativePath = uploadImgDir + day;
		String filePath = DataFileUtil.getWebappRoot() + "/" + relativePath;
		File dir = new File(filePath);
		if (!dir.exists() && !dir.isDirectory()) {
			dir.mkdirs();
		}
		BufferedOutputStream bos = null;
		java.io.FileOutputStream fos = null;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes =  decoder.decodeBuffer(base64);
 
			file = new File(filePath + "/" + fileName);
			OutputStream out = new FileOutputStream(filePath + "/" + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bytes);
		}finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		map.put("relativePath", relativePath + "/" + fileName);
		map.put("absolutePath", "/jianfuzengxiao/" + relativePath + "/" + fileName);
		return map;
	}

}
