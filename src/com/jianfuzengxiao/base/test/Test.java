package com.jianfuzengxiao.base.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONObject;
import com.jianfuzengxiao.base.common.HttpClientUtlis;
import com.jianfuzengxiao.base.common.MD5Util;

public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		//System.out.println(MD5Util.MD5Encode("123456QBa12a"));
		/*String str = "data/attach/image/20181215/1c3bd9e6dc71429587979ebc151cc0c3.jpg,data/attach/image/20181215/3f27b4e767484263a0aabbaa86f47b5f.png,data/attach/image/20181215/acecfec833ee4d4185265bf817e36776.png";
		List<String> sList = Arrays.asList(str.split(","));
		for(int i=0; i< sList.size(); i++){
			System.out.println(sList.get(i));
		}
		//System.out.println(MD5Util.MD5Encode("123456QBa12a"));
		/*List<AdminInfoMVO> list = new ArrayList<AdminInfoMVO>();
		AdminInfoMVO a1 = new AdminInfoMVO();
		a1.setAdminId("1");
		AdminInfoMVO a2 = new AdminInfoMVO();
		a2.setAdminId("2");
		list.add(a1);
		list.add(a2);
		List<String> sl = new ArrayList<>();
		for(AdminInfoMVO ali : list){
			sl.add(ali.getAdminId());
		}
		System.out.println(String.join(",", sl));*/
		/*String time1 = "2018/02/02-2019/02/02";
		System.out.println(StringUtils.substringAfter(time1, "-").replace("/", "-"));
		System.out.println(StringUtils.substringBefore(time1, "-"));*/	
		
		String url = "http://101.201.141.82/platform?username=ptuser&password=5ca33811121e41e0b64fd017814af26a";
		JSONObject json = new JSONObject();
		json.put("type", 0);
		json.put("userId", "1561651");
		json.put("userType", 1);
		json.put("appKey", "pasq");
		
		JSONObject json2 = new JSONObject();
		json2.put("title", "111");
		json2.put("body", "222222");
		json.put("body", json2);
		System.out.println(json.toString());
		System.out.println(HttpClientUtlis.doPost(url, json));
	}
}
