package com.microboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.microboot.util.RedisObjSerializer;

import redis.clients.jedis.JedisPoolConfig;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月22日 上午10:21:21 
* 类说明 
*/
@Configuration
public class RedisTwoConfig {

	//负责建立factory的连接工厂类
	public RedisConnectionFactory getRedisConnectionFactory(String hostName,
			int port,int maxActive,int maxIdle,int minIdle,int database ,long maxwait){
		JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
		jedisFactory.setHostName(hostName);
		jedisFactory.setPort(port);
		jedisFactory.setDatabase(database);
		JedisPoolConfig poolConfig = new JedisPoolConfig();//连接池配置
		poolConfig.setMaxTotal(maxActive);
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setMaxWaitMillis(maxwait);
		jedisFactory.setPoolConfig(poolConfig);
		jedisFactory.afterPropertiesSet();//初始化连接池配置
		return jedisFactory;
	}
	
	@Bean("redisTwo")
	public RedisTemplate<String, Object> getRedisTemplate(
			@Value("${spring.redis-two.host}") String hostName,
			@Value("${spring.redis-two.port}") int port,
			@Value("${spring.redis-two.database}") int database,
			@Value("${spring.redis-two.pool.max-active}") int maxActive,
			@Value("${spring.redis-two.pool.max-idle}") int maxIdle,
			@Value("${spring.redis-two.pool.min-idle}") int minIdle,
			@Value("${spring.redis-two.pool.max-wait}") long maxWait
			){
		RedisConnectionFactory factory =  (RedisConnectionFactory) this.getRedisConnectionFactory(
				hostName,port,maxActive,maxIdle,minIdle,database , maxWait);
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());//key 的序列化类型
		redisTemplate.setValueSerializer(new RedisObjSerializer());//value 的序列化类型
		return redisTemplate;
	}
}
 