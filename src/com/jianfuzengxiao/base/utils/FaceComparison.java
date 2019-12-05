package com.jianfuzengxiao.base.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.jianfuzengxiao.base.common.HttpClientUtlis;
import com.jianfuzengxiao.system.controller.AdminSysController;

import sun.misc.BASE64Encoder;
import javax.crypto.Mac;

@SuppressWarnings("restriction")
public class FaceComparison {
	private static Logger logger = LoggerFactory.getLogger(FaceComparison.class);
	
	public static final String APP_ID = "11511958";
    public static final String API_KEY = "YCKK6aTaKYMXobLQXoFsRQpq";
    public static final String SECRET_KEY = "EAMPOIB4z6WzWsDjcFx9ujOBxV09LSDh";
	
	public static void main(String[] args) throws Exception {
		/*String img1 = "/jianfuzengxiao/data/attach/image/cert/20191122/8f374127c8874c80a1730b7723a9acfd.png";
		String img2 = "/jianfuzengxiao/data/attach/image/face/20191122/1a8d2df6040f462d8f849d31ba872854.png";
		
		//String img3 = "/jianfuzengxiao/data/attach/image/cert/20191112/6acdfb20a8f94e908716133131d8884f.png";
		//String img4 = "/jianfuzengxiao/data/attach/image/face/20191116/c30a1bd8b5b94e85a40662288f481f90.png";
		System.out.println(faceUtils(img1, img2));*/
		
		// 初始化一个AipFace
		AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        String image1 = "http://pasq.niutuwangluo.com/jianfuzengxiao/data/attach/image/cert/20191122/4fbdaa9565be46649ee99e96a4733701.png";
        String image2 = "http://pasq.niutuwangluo.com/jianfuzengxiao/data/attach/image/face/20191122/b2f89d185d654212942f3b6f76a9c2e9.png";

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(image1, "URL");
        MatchRequest req2 = new MatchRequest(image2, "URL");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);
        System.out.println(res.toString(2));
        System.out.println(res.get("result"));
        JSONObject res2 = res.getJSONObject("result");
        System.out.println(res2.get("score"));
        /*System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.get("score"));*/
	}

	/** 0 通过 1 比对错误 2图像解码失败 3 系统忙 */
	public static int faceUtils(String image1, String image2){
		
		AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
		String url = "http://pasq.niutuwangluo.com";
		logger.info(url+image1);
		logger.info(url+image2);
        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(url+image1, "URL");
        MatchRequest req2 = new MatchRequest(url+image2, "URL");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);
        
        logger.info(requests.toString());
        JSONObject res = client.match(requests);
        logger.info(res.toString());
        
       // System.out.println(res2.get("score"));
    	
		try {
			if ((int)res.get("error_code") == 0) {
				JSONObject res2 = res.getJSONObject("result");
				double confidence = new BigDecimal(res2.get("score").toString()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				if (confidence >= 50) {
					return 0;
				}else {
					return 1;
				}
			}else {
				return 2;
			}
		} catch (Exception e) {
			logger.info("人脸比对", e);
			//System.out.println("ex");
			return 3;
		}
	}
	
	/** 0 通过 1 比对错误 2图像解码失败 3 系统忙 */
	/*public static int faceUtils(String img1, String img2){
		String url = "https://dtplus-cn-shanghai.data.aliyuncs.com/face/verify";
       
    	String ak_id = "3JMbkvG8UfjEyvqg"; //用户ak
        String ak_secret = "RRvDX85rmGRM126zl4EBkOGbKRqXmX"; 
        
        String url2 = "http://pasq.niutuwangluo.com"; 
        
    	JSONObject json = new JSONObject();
    	json.put("type", 0);
    	json.put("image_url_1", url2+img1);
    	json.put("image_url_2", url2+img2);
    	
    	JSONObject result;
		try {
			result = sendPost(url, json.toJSONString(), ak_id, ak_secret);
			logger.info(json.toJSONString());
			logger.info(result.toJSONString());
			if ((int)result.get("errno") == 0) {
				double confidence = new BigDecimal(result.get("confidence").toString()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				if (confidence >= 30) {
					return 0;
				}else {
					return 1;
				}
			}else if((int)result.get("errno") == 2000){
				return 2;
			}else {
				return 3;
			}
		} catch (Exception e) {
			logger.info("人脸比对", e);
			//System.out.println("ex");
			return 3;
		}
	}*/

	/*
	 * 计算MD5+BASE64
	 */
	public static String MD5Base64(String s) {
		if (s == null)
			return null;
		String encodeStr = "";
		byte[] utfBytes = s.getBytes();
		MessageDigest mdTemp;
		try {
			mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(utfBytes);
			byte[] md5Bytes = mdTemp.digest();
			BASE64Encoder b64Encoder = new BASE64Encoder();
			encodeStr = b64Encoder.encode(md5Bytes);
		} catch (Exception e) {
			throw new Error("Failed to generate MD5 : " + e.getMessage());
		}
		return encodeStr;
	}

	/*
	 * 计算 HMAC-SHA1
	 */
	public static String HMACSha1(String data, String key) {
		String result;
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(data.getBytes());
			result = (new BASE64Encoder()).encode(rawHmac);
		} catch (Exception e) {
			throw new Error("Failed to generate HMAC : " + e.getMessage());
		}
		return result;
	}

	/*
	 * 等同于javaScript中的 new Date().toUTCString();
	 */
	public static String toGMTString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
		df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
		return df.format(date);
	}

	/*
	 * 发送POST请求
	 */
	public static com.alibaba.fastjson.JSONObject sendPost(String url, String body, String ak_id, String ak_secret) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		int statusCode = 200;
		try {
			URL realUrl = new URL(url);
			/*
			 * http header 参数
			 */
			String method = "POST";
			String accept = "application/json";
			String content_type = "application/json";
			String path = realUrl.getFile();
			String date = toGMTString(new Date());
			// 1.对body做MD5+BASE64加密
			String bodyMd5 = MD5Base64(body);
			String stringToSign = method + "\n" + accept + "\n" + bodyMd5 + "\n" + content_type + "\n" + date + "\n"
					+ path;
			// 2.计算 HMAC-SHA1
			String signature = HMACSha1(stringToSign, ak_secret);
			// 3.得到 authorization header
			String authHeader = "Dataplus " + ak_id + ":" + signature;
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", accept);
			conn.setRequestProperty("content-type", content_type);
			conn.setRequestProperty("date", date);
			conn.setRequestProperty("Authorization", authHeader);
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(body);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			statusCode = ((HttpURLConnection) conn).getResponseCode();
			if (statusCode != 200) {
				in = new BufferedReader(new InputStreamReader(((HttpURLConnection) conn).getErrorStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (statusCode != 200) {
			throw new IOException("\nHttp StatusCode: " + statusCode + "\nErrorMessage: " + result);
		}
		return com.alibaba.fastjson.JSONObject.parseObject(result);
	}

	/*
	 * GET请求
	 */
	public static String sendGet(String url, String ak_id, String ak_secret) throws Exception {
		String result = "";
		BufferedReader in = null;
		int statusCode = 200;
		try {
			URL realUrl = new URL(url);
			/*
			 * http header 参数
			 */
			String method = "GET";
			String accept = "application/json";
			String content_type = "application/json";
			String path = realUrl.getFile();
			String date = toGMTString(new Date());
			// 1.对body做MD5+BASE64加密
			// String bodyMd5 = MD5Base64(body);
			String stringToSign = method + "\n" + accept + "\n" + "" + "\n" + content_type + "\n" + date + "\n" + path;
			// 2.计算 HMAC-SHA1
			String signature = HMACSha1(stringToSign, ak_secret);
			// 3.得到 authorization header
			String authHeader = "Dataplus " + ak_id + ":" + signature;
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", accept);
			connection.setRequestProperty("content-type", content_type);
			connection.setRequestProperty("date", date);
			connection.setRequestProperty("Authorization", authHeader);
			connection.setRequestProperty("Connection", "keep-alive");
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			statusCode = ((HttpURLConnection) connection).getResponseCode();
			if (statusCode != 200) {
				in = new BufferedReader(new InputStreamReader(((HttpURLConnection) connection).getErrorStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			}
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (statusCode != 200) {
			throw new IOException("\nHttp StatusCode: " + statusCode + "\nErrorMessage: " + result);
		}
		return result;
	}

}
