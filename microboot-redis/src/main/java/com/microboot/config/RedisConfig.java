package com.microboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.microboot.util.RedisObjSerializer;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月19日 下午4:11:24 
* 类说明 
*/
@Configuration
public class RedisConfig {
	
	@Bean
	public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory factory){
		
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());//key 的序列化类型
		redisTemplate.setValueSerializer(new RedisObjSerializer());//value 的序列化类型
		return redisTemplate;
	}

}
 