package com.jianfuzengxiao.base.common;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class PushUtils {
	private static Logger logger = LoggerFactory.getLogger(PushUtils.class);
	
	public static void toPush(String userId, String title, String content, String type) throws ClientProtocolException, IOException{
		String url = "http://property.pasq.com/message/platform?username=ptuser&password=5ca33811121e41e0b64fd017814af26a";
		JSONObject json = new JSONObject();
		json.put("type", 0);
		json.put("userId", userId);
		json.put("userType", 1);
		json.put("appKey", "pasq");
		
		JSONObject json2 = new JSONObject();
		json2.put("title", title);
		json2.put("body", content);
		json2.put("type", type);
		json.put("body", json2);
		logger.info(json.toString());
		logger.info(HttpClientUtlis.doPost(url, json).toJSONString());
	}
}
