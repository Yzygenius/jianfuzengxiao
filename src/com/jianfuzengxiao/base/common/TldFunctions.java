package com.jianfuzengxiao.base.common;

import org.apache.commons.lang.StringUtils;

import com.bamboo.framework.cache.CacheManager;

/**
 * 自定义标签
 *
 * @author Z.jh
 * 2017年3月19日
 */
public class TldFunctions {
	private static final String BLANK = "";

	private static TldFunctions instance = new TldFunctions();

    public static TldFunctions getInstance() {
        return instance;
    }

    /**
     * 获取数据库配置表信息
     * @param key 键值
     * @return
     */
    public static String getConfig(String key) {
    	if (StringUtils.isBlank(key))
    		return BLANK;
    	return getConfig(key, BLANK);
    }
    
    /**
     * 获取数据库配置表信息
     * @param key 键值
     * @param def 默认值（如果返回值为空取该值）
     * @return
     */
    public static String getConfig(String key, String def) {
    	if (StringUtils.isBlank(key))
    		return BLANK;
    	// 从缓存中读取
    	CacheManager cacheManager = CacheManager.getInstance();
    	String val = (String) cacheManager.get("table.cache.idvalue.config", key.toUpperCase());
    	val = StringUtils.isEmpty(val) ? def : val;
    	return StringUtils.trimToEmpty(val);
    }

}
