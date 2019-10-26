package com.jianfuzengxiao.base.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.alipay.api.domain.Data;
import com.bamboo.framework.common.util.DateUtil;

public class TimeUtils {
	
	public static String nowTimeSdf(long time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(time);
	}
	
	public static String addMinuteTimeSdf(long time, int addtime){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, addtime);
		return sdf.format(calendar.getTime());
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.now());
		String h = nowTimeSdf(Long.parseLong("20190808152708"));
		System.out.println(h);
		
		String b = addMinuteTimeSdf(DateUtil.now(), 0);
		System.out.println(b);
		System.out.println(Long.parseLong(b) - Long.parseLong(h) > 19900 ? true : false);
	}
	
}
