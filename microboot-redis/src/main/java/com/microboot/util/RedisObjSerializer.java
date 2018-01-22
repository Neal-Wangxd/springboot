package com.microboot.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月19日 下午3:56:16 
* 类说明 : redis序列化对象和返序列化工具类
*/
public class RedisObjSerializer implements RedisSerializer<Object> {

	private Converter<Object, byte[]> serializingConverter = new SerializingConverter();
	private Converter<byte[], Object> deserializingConverter = new DeserializingConverter();
	private static final byte[] EMPTY_BYTE_ARRY = new byte[0];
	
	
	/**
	 * 序列化
	 */
	@Override
	public byte[] serialize(Object obj) throws SerializationException {
		if(null != obj){
			return this.serializingConverter.convert(obj);
		}
		return EMPTY_BYTE_ARRY;
	}
	
	/**
	 * 返序列化
	 */
	@Override
	public Object deserialize(byte[] data) throws SerializationException {
		if(null != data && data.length > 0){
			return this.deserializingConverter.convert(data);
		}
		return EMPTY_BYTE_ARRY;
	}


}
 