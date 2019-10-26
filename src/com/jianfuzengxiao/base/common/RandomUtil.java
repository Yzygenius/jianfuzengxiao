package com.jianfuzengxiao.base.common;

import java.util.Random;

/**
 * 随机数工具类
 *
 * @author Z.jh
 * 2017年3月22日
 */
public class RandomUtil {
	
	private static final char[] letter = new char[]{'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static String randomStr(int len) {
		if (len <= 0) {
			return "";
		}
		
		StringBuffer buf = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			buf.append(letter[random.nextInt(letter.length)]);
		}
		return buf.toString();
	}

}
