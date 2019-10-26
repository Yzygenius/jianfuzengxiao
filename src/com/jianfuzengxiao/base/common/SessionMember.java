package com.jianfuzengxiao.base.common;

import javax.servlet.http.HttpSession;

import com.alibaba.druid.util.StringUtils;
import com.weishangcheng.pub.entity.MemberInfoMVO;

/**
 * 保存会员会话
 *
 * @author Z.jh
 * 2017年4月4日
 */
public class SessionMember {
	
	private static final String SESSION_WSC_MEMBER = "SESSION_WSC_MEMBER"; 
	
	public static final String MEMBER_ID = "SESSION_WSC_MEMBER.MEMBER_ID";
	public static final String OPENID = "SESSION_WSC_MEMBER.OPENID";
	public static final String NICK_NAME = "SESSION_WSC_MEMBER.NICK_NAME";
	public static final String SEX = "SESSION_WSC_MEMBER.SEX";
	public static final String COUNTRY = "SESSION_WSC_MEMBER.COUNTRY";
	public static final String PROVINCE = "SESSION_WSC_MEMBER.PROVINCE";
	public static final String CITY = "SESSION_WSC_MEMBER.CITY";
	public static final String HEADIMGURL = "SESSION_WSC_MEMBER.HEADIMGURL";
	public static final String P_OPENIDID = "SESSION_WSC_MEMBER.P_OPENIDID";
	public static final String ACCOUNT_STATE = "SESSION_WSC_MEMBER.ACCOUNT_STATE";
	public static String get(String key) {
		String val = null;

		HttpSession session = HttpHelper.getHttpSession();
		MemberInfoMVO memberMVO = (MemberInfoMVO) session.getAttribute(SESSION_WSC_MEMBER);
		if (memberMVO == null) {
			return "";
		}
		
		switch (key) {
		case MEMBER_ID:
			val = memberMVO.getMemberId();
			break;
		case OPENID:
			val = memberMVO.getOpenid();
			break;
		case NICK_NAME:
			val = memberMVO.getNickname();
			break;
		case SEX:
			val = memberMVO.getSex();
			break;
		case COUNTRY:
			val = memberMVO.getCountry();
			break;
		case PROVINCE:
			val = memberMVO.getProvince();
			break;
		case CITY:
			val = memberMVO.getCity();
			break;
		case HEADIMGURL:
			val = memberMVO.getHeadimgurl();
			break;
		case P_OPENIDID:
			val = memberMVO.getPOpenidid();
			break;
		case ACCOUNT_STATE:
			val = memberMVO.getAccountState();
			break;
		default:
			break;
		}
		return val;
	}
	
	/**
	 * 从session中读取会员对象
	 */
	public static MemberInfoMVO getMemberInfo() {
		HttpSession session = HttpHelper.getHttpSession();
		return (MemberInfoMVO) session.getAttribute(SESSION_WSC_MEMBER);
	}
	
	public static void reflesh(MemberInfoMVO memberMVO) {
		HttpHelper.getHttpSession().setAttribute(SESSION_WSC_MEMBER, memberMVO);
	}
	
	public static void destroy() {
		HttpHelper.getHttpSession().removeAttribute(SESSION_WSC_MEMBER);
	}
	
	public static boolean isLogined() {
		MemberInfoMVO memberMVO = (MemberInfoMVO) HttpHelper.getHttpSession().getAttribute(SESSION_WSC_MEMBER);
		return memberMVO != null;
	}
	
}
