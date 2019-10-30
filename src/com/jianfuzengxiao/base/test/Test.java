package com.jianfuzengxiao.base.test;

import java.util.Arrays;
import java.util.List;

import com.jianfuzengxiao.base.common.MD5Util;

public class Test {

	public static void main(String[] args) {
		System.out.println(MD5Util.MD5Encode("123456QBa12a"));
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
	}
}
