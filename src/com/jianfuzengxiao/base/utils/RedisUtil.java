package com.jianfuzengxiao.base.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.bamboo.framework.exception.SysException;
import com.bamboo.framework.spring.SpringHelper;
import com.jianfuzengxiao.base.common.RC;

/**
 * Redis操作工具类
 */
@SuppressWarnings("unchecked")
public class RedisUtil {
	private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);
	
	public static void addHashObject(String key, Object hashKey, Object obj) throws SysException {
		try {
			byte[] serializeToekn = serialize(obj);
			RedisTemplate<String, String> redisTemplate = SpringHelper.getBean(RedisTemplate.class);
			HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
			ops.put(key, hashKey, Base64.encodeBase64String(serializeToekn));
		} catch (Exception e) {
			String log = "保存hash对象到redis出错";
			logger.error(log, e);
			throw new SysException(log, RC.OTHER_ERROR_CODE, e);
		}
	}
	
	public static void addHashObjectId(String key, Object hashKey, Object obj) throws SysException {
		try {
			RedisTemplate<String, String> redisTemplate = SpringHelper.getBean(RedisTemplate.class);
			HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
			ops.put(key, hashKey, obj);
		} catch (Exception e) {
			String log = "保存hash对象到redis出错";
			logger.error(log, e);
			throw new SysException(log, RC.OTHER_ERROR_CODE, e);
		}
	}
	
	public static Object getHashObject(String key, String hashKey) throws SysException {
		try {
			RedisTemplate<String, String> redisTemplate = SpringHelper.getBean(RedisTemplate.class);
			HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
			String str = (String) ops.get(key, hashKey);
			if (str == null) {
				return null;
			}
			return str == null ? null : unserizlize(Base64.decodeBase64(str));
		} catch (Exception e) {
			String log = "从redis获取hash对象出错";
			logger.error(log, e);
			throw new SysException(log, RC.OTHER_ERROR_CODE, e);
		}
	}
	
	public static Object getHashObjectId(String key, String hashKey) throws SysException {
		try {
			RedisTemplate<String, String> redisTemplate = SpringHelper.getBean(RedisTemplate.class);
			HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
			String str = (String) ops.get(key, hashKey);
			if (str == null) {
				return null;
			}
			return str == null ? null : str;
		} catch (Exception e) {
			String log = "从redis获取hash对象出错";
			logger.error(log, e);
			throw new SysException(log, RC.OTHER_ERROR_CODE, e);
		}
	}
	
	public static void removeHashObject(String key, String hashKey) throws SysException {
		try {
			RedisTemplate<String, String> redisTemplate = SpringHelper.getBean(RedisTemplate.class);
			HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
			ops.delete(key, hashKey);
		} catch (Exception e) {
			String log = "从redis删除hash对象出错";
			logger.error(log, e);
			throw new SysException(log, RC.OTHER_ERROR_CODE, e);
		}
	}
	
	// 序列化 
    private static byte[] serialize(Object obj) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
        	throw new SysException("执行对象序列化出错", RC.OTHER_ERROR_CODE, e);
        }
    }
    /**
     * @author 
     * @serialData 
     * @param bt
     * @return
     */
    // 反序列化
    private static Object unserizlize(byte[] bt){
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;
        try {
        	bais = new ByteArrayInputStream(bt);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
        	throw new SysException("执行对象序列化出错", RC.OTHER_ERROR_CODE, e);
        }
    }

}
