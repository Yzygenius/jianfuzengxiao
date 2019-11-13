package com.jianfuzengxiao.base.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpClientUtlis {
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtlis.class);

	@SuppressWarnings("unchecked")
	public static Map<String, Object> doGet(String url) {
		Map<String, Object> map = null;
		/*ResourceBundle resourceBundle = ResourceBundle.getBundle("web");
		String requestUrl = resourceBundle.getString("sys.http.request.api.url") + url;*/
		
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			if (null != entity) {
				String string = EntityUtils.toString(entity);
				System.out.println("响应状态码:" + httpResponse.getStatusLine());
				System.out.println("-------------------------------------------------");
				System.out.println("响应内容:" + string);
				System.out.println("-------------------------------------------------");
				if (StringUtils.isNotBlank(string)) {
					JSONObject jsonObject = JSONObject.parseObject(string);
					map = (Map<String, Object>) jsonObject;
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// }
		return map;
	}

	public static JSON doPost(String url, Map<String, String> params)
			throws UnsupportedEncodingException {
		// Map<String, Object> map = null;
		String result = null;
		String requestUrl = url;
		//logger.info("==================这是【post】请求");
		//logger.info("请求路径============【URL】 " + requestUrl);
		HttpPost httpPost = new HttpPost(requestUrl);
		List<NameValuePair> requestParams = new ArrayList<NameValuePair>();
		if (params != null) {
			for (String key : params.keySet()) {
				requestParams.add(new BasicNameValuePair(key, params.get(key)));
			}
		}
		httpPost.setEntity(new UrlEncodedFormEntity(requestParams));
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpPost);
			HttpEntity entity = httpResponse.getEntity();
			if (null != entity) {
				String string = EntityUtils.toString(entity);
				System.out.println("响应状态码:" + httpResponse.getStatusLine());
				System.out.println("-------------------------------------------------");
				System.out.println("响应内容:" + string);
				System.out.println("-------------------------------------------------");
				result = string;
				// if (StringUtils.isNotBlank(string)) {
				// JSONObject jsonObject = JSONObject.fromObject(string);
				// map = (Map<String, Object>) jsonObject;
				// }
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return JSON.parseObject(result);
	}
	
	@SuppressWarnings("deprecation")
	public static JSONObject doPost(String url, JSONObject param) throws ClientProtocolException, IOException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
 
        // 设置请求的header
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
 
        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject jsonObject = JSONObject.parseObject(json2);
 
        // 打印执行结果
        //System.out.println(jsonObject);
        return jsonObject;
	}
	
	public static void main(String[] args) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("client_id", "55");
		map.put("client_secret", "c95c468cead948e29c6ca5475aac76a5");
		map.put("username", "17700008851");
		map.put("password", "qweqwe123");
		map.put("grant_type", "password");
		map.put("type", "5");
		//响应内容:{"errcode":40029,"errmsg":"invalid code, hints: [ req_id: oGAfFXyMe-W.UQPa ]"}
		System.out.println(doGet("https://api.weixin.qq.com/sns/jscode2session?appid=&secret=&js_code=JSCODE&grant_type=authorization_code"));
	}

}
