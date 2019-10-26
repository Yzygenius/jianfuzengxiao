package com.jianfuzengxiao.base.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.bamboo.framework.controller.SuperController;
import com.bamboo.framework.entity.PageInfo;
import com.bamboo.framework.exception.AppException;
import com.bamboo.framework.exception.SysException;
import com.jianfuzengxiao.base.common.RC;
import com.jianfuzengxiao.base.entity.ApiResult;

/**
 * 后台管理基础控制器
 * 
 * @author Z.jh
 * @Date 2017年3月10日
 */
public class BaseController extends SuperController implements HandlerInterceptor {
	
	private final static boolean IS_DEBUG = true;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		/*
		 * 方法调用后调用该方法，返回数据给请求页
		 * 框架改造，已注释
		if (isLegalView(modelAndView)) {
			modelAndView.addObject("currentUser", userService.selectById(getCurrentUserId()));
			modelAndView.addObject("menuList", permissionService.selectMenuVOByUserId(getCurrentUserId()));
		}
		 */
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	/**
	 * <p>
	 * 将page对象转换为 JSON
	 * </p>
	 * @param page 分页对象
	 * @return
	 */
	protected String jsonPage(PageInfo page) {
		JSONObject jo = new JSONObject();
		jo.put("total", page.getTotal());
		jo.put("rows", page.getRows());
		return toJson(jo);
	}

	@Override
	protected PageInfo getPage(int size) {
		int _size = size, _index = 1;
		if (StringUtils.isNotBlank(request.getParameter("pageSize"))) {
			_size = Integer.parseInt(request.getParameter("pageSize"));
		} else if (StringUtils.isNotBlank(request.getParameter("rows"))) {
			_size = Integer.parseInt(request.getParameter("rows"));
		}
		if (StringUtils.isNotBlank(request.getParameter("page"))) {
			_index = Integer.parseInt(request.getParameter("page"));
		}
		return new PageInfo(_index, _size);
	}
	/**
	 * 每页显示条数
	 * @return
	 */
	protected PageInfo getApiPage() {
		int _size = 10, _index = 1;
		if (StringUtils.isNotBlank(request.getParameter("pageSize"))) {
			_size = Integer.parseInt(request.getParameter("pageSize"));
		}
		if (StringUtils.isNotBlank(request.getParameter("page"))) {
			_index = Integer.parseInt(request.getParameter("page"));
		}
		return new PageInfo(_index, _size);
	}
	
	/**
	 * 转到404页面
	 * @return
	 */
	protected String show404() {
		return "/error/404";
	}
	
	protected String show500() {
		return "/error/500";
	}
	
	protected String show500(String message) {
		request.setAttribute("message", message);
		return "/error/500";
	}
	
	protected String show303(String message, String url) {
		request.setAttribute("message", message);
		request.setAttribute("url", url);
		return "/error/303";
	}
	
	protected String apiResult(RC rc) {
		return apiResult(rc.code, rc.msg);
	}
	
	protected String apiResult(String code, String msg) {
		return toJson(new ApiResult(code, msg));
	}
	
	protected String apiSysErrResult(String code, String msg) {
		return IS_DEBUG ? toJson(new ApiResult(code, msg)) : apiResult(RC.OTHER_ERROR);
	}

	protected String apiResult(String code, String msg, Object data) {
		return toJson(new ApiResult(code, msg, data));
	}
	
	protected String apiResult(String code, String msg, Object data, SimplePropertyPreFilter filter, SerializerFeature... feature) {
		SerializerFeature[] featureNew = Arrays.copyOf(feature, feature.length + 1);
		featureNew[feature.length] = SerializerFeature.BrowserCompatible;
		return JSON.toJSONString(new ApiResult(code, msg, data), filter, SerializerFeature.BrowserCompatible);
	}
	
	protected String apiResult(String code, String msg, Object data, SerializerFeature... feature) {
		return toJsonFeature(new ApiResult(code, msg, data), feature);
	}
	
	protected String exceptionResult(String msg, Exception e) {
		return exceptionResult(logger, msg, e);
	}

	protected String exceptionResult(Logger logger, String msg, Exception e) {
		if (e instanceof SysException) {
			SysException se = (SysException) e;
			logger.error(msg, e);
			return apiSysErrResult(se.getErrId(), se.getErrMsg());
		}
		if (e instanceof AppException) {
			AppException ae = (AppException) e;
			
			
			logger.debug(msg + ": " + ae.getErrMsg());
			return apiResult(ae.getErrId(), ae.getErrMsg());
		}
		logger.error(msg, e);
		return apiResult(RC.OTHER_ERROR);
	}
	
	protected String callbackException(String msg, Exception e) {
		return exceptionResult(logger, msg, e);
	}
	
	protected String callbackException(Logger logger, String msg, Exception e) {
		if (e instanceof SysException) {
			SysException se = (SysException) e;
			logger.error(msg, e);
			return callback(false, se.getErrMsg());
		}
		if (e instanceof AppException) {
			AppException ae = (AppException) e;
			logger.debug(msg + ": " + ae.getErrMsg());
			return callback(false, ae.getErrMsg());
		}
		logger.error(msg, e);
		return callback(false, e.getMessage());
	}

}
