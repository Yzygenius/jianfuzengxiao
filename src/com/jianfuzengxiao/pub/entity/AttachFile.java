package com.jianfuzengxiao.pub.entity;

import com.bamboo.framework.entity.Entity;

public class AttachFile extends Entity {

	// 文件状态
	public final static String STATE_TEMP = "T";
	public final static String STATE_PRODUCE = "P";
	
	// 文件类型
	public final static String TYPE_IMAGE = "I";
	public final static String TYPE_FILE = "F";
		
	protected String fileId;

	protected String fileType;

	protected String fileName;

	protected String saveName;

	protected String state;

	protected String sts;

	protected String createTime;

	protected String updateTime;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
