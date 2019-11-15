package com.jianfuzengxiao.base.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PushUtils {
	private static Logger logger = LoggerFactory.getLogger(PushUtils.class);
	
	/** 通知 */
	public static void toPush(String userId, String opId, String title, String content, String type) throws ClientProtocolException, IOException{
		String url = "http://property.pasq.com/message/platform?username=ptuser&password=5ca33811121e41e0b64fd017814af26a";
		JSONObject json = new JSONObject();
		json.put("type", 1);//消息类型 0通知 1消息 
		json.put("userId", opId);
		json.put("userType", "1");// 目标类型：1 业主 
		json.put("appKey", "pasq");//系统标识： pasq
		
		/*JSONObject json3 = new JSONObject();
		json3.put("type", type);
		json3.put("content", content);*/
		
		JSONObject json2 = new JSONObject();
		json2.put("title", title);//消息头
		json2.put("body", content);//消息体
		json2.put("type", type);//消息业务类型
		
		//json2.put("extend", json3);
		
		json.put("body", json2);//消息内容
		
		
		logger.info(json.toString());
		logger.info(HttpClientUtlis.doPost(url, json).toJSONString());
	}
	
	/** 积分 */
	public static void toIntegral(String userId, String content, int type) throws ClientProtocolException, IOException{
		String url = "http://api.usnoon.com/thirdintegral/upduserintebythirdtype?username=ptuser&password=5ca33811121e41e0b64fd017814af26a"
				+ "&type="+type+"&userId="+userId+"&content="+content+"&costinte=0";
		JSONObject json = new JSONObject();
		/*json.put("username", "ptuser");
		json.put("password", "5ca33811121e41e0b64fd017814af26a");
		json.put("type", type);// int   更新类型 31 业主申请通过；32 租户，家属，员工申请通过；33 信息更新申请通过
		json.put("userId", userId);//用户ID
		json.put("content", content);//描述
		json.put("costinte", 0);//默认值 0
*/		
		logger.info(json.toString());
		logger.info(HttpClientUtlis.doPost(url, json).toJSONString());
	}
}
