package com.jianfuzengxiao.base.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.UUID;

/**
 * double 数值计算或转换
 * 
 * @author 闫子扬
 * @date 2018年6月29日11:21:15
 * 
 */
public class BigDouble {

	/**
	 * 相乘
	 * 计算，将吨位和单价同时扩大10000倍，计算完还原，防止精度丢失 参数： 吨位，单价
	 */
	public static double getPriceCount(double price, double number) {
		double price_count = ((price * 10000) * (number * 10000)) / 100000000;
		return price_count;
	}
	
	/**
	 * 相乘
	 * 计算，将吨位和单价同时扩大10000倍，计算完还原，防止精度丢失 参数： 吨位，单价
	 */
	public static double getPriceCount(double price, double number, double count) {
		double price_count = ((price * 100) * (number * 100)) * (count * 100) / 1000000;
		return price_count;
	}
	
	/**
	 * 除法
	 */
	public static double getDivisionCount(double price, double number) {
		double price_count = ((price * 100) / (number * 100));
		return price_count;
	}
	
	/**
	 * 相加。
	 * 计算，两个数都扩大10000倍。计算后还原，防止精度丢失。
	 */
	public static double getAdditionCount(double numberOne, double numberTwo){
		double count = (numberOne * 10000) + (numberTwo * 10000);
		return count/10000;
	}
	
	/**
	 * 相减。
	 * 计算，两个数都扩大10000倍。计算后还原，防止精度丢失。
	 */
	public static double getMinusCount(double numberOne, double numberTwo){
		double count = (numberOne * 10000) - (numberTwo * 10000);
		return count/10000;
	}

	/**
	 * 进位，保留小数点后两位
	 * 
	 * @param double
	 * @return
	 */
	public static double getCarryCount(double number) {
		number = number * 10000;
		BigDecimal carryCount = new BigDecimal(number).divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_UP);
		return carryCount.doubleValue();
	}

	/**
	 * 舍位，保留小数点后两位
	 * 
	 * @param double
	 * @return
	 */
	public static double getHouseCount(double number) {
		number = number * 10000;
		BigDecimal houseCount = new BigDecimal(number).divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_DOWN);
		return houseCount.doubleValue();
	}

	/**
	 * 四舍五入，保留小数点后两位
	 * 
	 * @param double
	 * @return
	 */
	public static double getRoundingCount(double number) {
		BigDecimal roundingCount = new BigDecimal(number).setScale(2, BigDecimal.ROUND_HALF_UP);
		return roundingCount.doubleValue();
	}

	/**
	 * 去除科学计数法
	 * 
	 * @param double
	 * @return string
	 */
	public static String scientificNotation(double number) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		String num = nf.format(number);
		return num;
	}

	/**
	 * 
	 * 将银行卡中间八个字符隐藏为*
	 */
	public static String getHideBankCardNum(String bankCardNum) {
		try {
			if (bankCardNum == null)
				return "未绑定";

			int length = bankCardNum.length();

			if (length > 4) {
				String startNum = bankCardNum.substring(0, 4);
				String endNum = bankCardNum.substring(length - 4, length);
				bankCardNum = startNum + " **** **** " + endNum;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankCardNum;
	}

	public static synchronized String getUUID() {
		return UUID.randomUUID().toString().replaceAll("\\-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
