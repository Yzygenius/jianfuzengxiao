package com.jianfuzengxiao.base.wx;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

 
public class AuthUtil {
 
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity != null){
            String result = EntityUtils.toString(entity,"utf-8");
            jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }
   
}

