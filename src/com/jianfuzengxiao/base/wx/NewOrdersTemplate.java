package com.jianfuzengxiao.base.wx;

import java.util.Map;

public class NewOrdersTemplate {
    private Map<String, TemplateData> data;
    private String touser;
    private String url;
    private String template_id;
    private String form_id;
    private miniprogram miniprogram;
    
    
	public miniprogram getMiniprogram() {
		return miniprogram;
	}
	public void setMiniprogram(miniprogram miniprogram) {
		this.miniprogram = miniprogram;
	}
	public Map<String, TemplateData> getData() {
		return data;
	}
	public void setData(Map<String, TemplateData> m) {
		this.data = m;
	}

	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	
}
