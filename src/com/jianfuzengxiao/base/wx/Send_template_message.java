package com.jianfuzengxiao.base.wx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Send_template_message {
	/**
	 * * 发送模板消息 appId 公众账号的唯一标识 appSecret 公众账号的密钥 openId 用户标识
	 * 
	 * @throws IOException
	 */
	public static void send_template_message(String openId) throws IOException {
		String access_token = AuthUtil.doGetJson(Constants.ACCESS_TOKEN_URL).getString("access_token");
		System.out.println(access_token);
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
		NewOrdersTemplate temp = new NewOrdersTemplate();
		WxMssVo wxMssVo = new WxMssVo();
		Map<String, TemplateData> m = new HashMap<>(6);
		TemplateData first = new TemplateData();
		first.setValue("购买买地点");
		m.put("first", first);
		TemplateData keyword1 = new TemplateData();
		keyword1.setValue("购买买地点");
		m.put("keyword1", keyword1);

		TemplateData keyword2 = new TemplateData();
		keyword2.setValue("购买时间");
		m.put("keyword2", keyword2);
		wxMssVo.setData(m);

		TemplateData keyword3 = new TemplateData();
		keyword3.setValue("交易单号");
		m.put("keyword3", keyword3);
		wxMssVo.setData(m);

		TemplateData keyword4 = new TemplateData();
		keyword4.setValue("这里填取件地址");
		m.put("keyword4", keyword4);
		wxMssVo.setData(m);
		temp.setTouser(openId);
		TemplateData remark = new TemplateData();
		remark.setValue("这里填取件地址");
		m.put("remark", remark);
		wxMssVo.setData(m);
		temp.setTouser(openId);
		// temp.setTemplate_id("NeGvJ7LJ7ERfbvFMTYhiRCoDFy8WhDDln8HdREyGcLs");
		temp.setTemplate_id(Constants.Template_id);
		// temp.setUrl("http://www.baidu.com");
		// temp.setUrl("http://www.baidu.com");
		// miniprogram miniprogra=new miniprogram();
		// miniprogra.setAppid("");//所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系）
		// miniprogra.setPagepath("pagepath");//
		// 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar）
		temp.setForm_id("formid");
		temp.setData(m);

		String jsonString = JSONObject.toJSONString(temp).toString().replace("day", "Day");
		System.out.println(jsonString);
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonString);
		System.out.println(jsonObject);

		int result = 0;

		// logger.info("模板消息发送结果："+result};

	}

}
