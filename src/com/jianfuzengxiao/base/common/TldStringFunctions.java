package com.jianfuzengxiao.base.common;

import org.apache.commons.lang.StringUtils;


/**
 * 字符串操作-自定义标签
 *
 * @author Z.jh
 * 2017年3月19日
 */
public class TldStringFunctions {

	/**
	 * 截取左侧字符串
	 * @param str
	 * @return
	 */
    public static String left(String str, int len) {
    	if (str == null 
    			|| str.length() == 0
    			|| len <= 0) {
    		return "";
    	}
    	if (str.length() <= len) {
    		return str;
    	}
    	return str.substring(0, len);
    }
    
    /**
     * 截取左侧字符串，若字符串过长，以exStr结尾
     * @param str
     * @param len
     * @param exStr
     * @return
     */
    public static String leftEx(String str, int len, String exStr) {
    	if (str == null 
    			|| str.length() == 0
    			|| len <= 0) {
    		return "";
    	}
    	if (str.length() <= len) {
    		return str;
    	}
    	return str.substring(0, len) + exStr;
    }
    
    /**
     * 截取右侧字符串
     * @param str
     * @return
     */
    public static String right(String str, int len) {
    	if (str == null 
    			|| str.length() == 0
    			|| len <= 0) {
    		return "";
    	}
    	if (str.length() <= len) {
    		return str;
    	}
    	return str.substring(str.length() - len);
    }

    /**
     * 隐藏用户名部分字符
     * @param str
     * @return
     */
    public static String hideUsername(String str) {
		if (str == null 
    			|| str.length() == 0) {
    		return "";
    	}
		int len = str.length();
    	switch (len) {
    	case 2:
    		return str.charAt(0) + "*";
		case 3:
			return str.charAt(0) + "**" + str.charAt(2);
		case 4:
			return str.charAt(0) + "**" + str.charAt(3);
		case 5:
			return str.substring(0, 2) + "**" + str.charAt(len-1);
		default:
			return str.substring(0, 2) + "**" + str.substring(len-3);
		}
    }
    
	/**
	 * 转换为大写
	 * @param str
	 * @return
	 */
    public static String upper(String str) {
    	if (str != null) {
			return str.toUpperCase();
		}
    	return str;
    }
    
    /**
     * 转换为小写
     * @param str
     * @return
     */
    public static String lower(String str) {
    	if (str != null) {
    		return str.toLowerCase();
    	}
    	return str;
    }

    /**
     * 拼接字符串
     * @param str
     * @return
     */
    public static String concat(String str1, String str2) {
    	return str1 + str2;
    }
    
    /**
     * 拼接字符串
     * @param str
     * @return
     */
    public static String concat3(String str1, String str2, String str3) {
    	return str1 + str2 + str3;
    }

    /**
     * 满足字符串列表任何一项
     * @param str
     * @return
     */
    public static boolean equalsAny(String src, String arrayStr, String splitChar) {
    	if (StringUtils.isBlank(src) || StringUtils.isBlank(arrayStr)) {
			return false;
		}
    	String[] array = arrayStr.split(StringUtils.defaultIfEmpty(splitChar, ","));
    	for (String a : array) {
			if (StringUtils.equals(a, src)) {
				return true;
			}
		}
    	return false;
    }
    
    public static void main(String[] args) {
		
    	System.out.println(equalsAny("B", "A,F,E,G", ","));
    	
	}
    
}
