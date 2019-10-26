package com.jianfuzengxiao.job.codegenerator;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
/***

 *@Description：读取文properties
 */
public class PropertiesHelper {

	private static final Map<String, String> properties = new HashMap<String, String>();
	static {
		try {
//			Properties pps = new Properties();
//			pps.load(PropertiesHelper.class.getClassLoader().getResourceAsStream("DBSource.properties"));
//			//处理重复的值.
//			for (Entry<Object, Object> entry : pps.entrySet()) {
//				properties.put(entry.getKey().toString().trim(), entry.getValue().toString().trim());
//			}
			properties.put("jdbc.driver", "com.mysql.jdbc.Driver");
			properties.put("jdbc.url", "jdbc:mysql://192.168.124.10:3306/jianfuzengxiao?useUnicode=true&characterEncoding=utf8");
			properties.put("jdbc.username", "root");
			properties.put("jdbc.password", "123");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *通过key值去获取值.
	 */
	public static String getValueByKey(String name) {
		return properties.get(name);
	}

}
