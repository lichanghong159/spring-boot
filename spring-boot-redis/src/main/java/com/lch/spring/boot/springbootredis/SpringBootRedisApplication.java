package com.lch.spring.boot.springbootredis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@SpringBootApplication
public class SpringBootRedisApplication {
	public static ObjectMapper objectMapperForRedis;
	static {
		objectMapperForRedis = new ObjectMapper();
		objectMapperForRedis.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapperForRedis.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		final StringRedisTemplate template = new StringRedisTemplate(factory);
		// template.setValueSerializer(new Jackson2JsonRedisSerializer<U2Response>(
		// U2Response.class)); //请注意这里
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapperForRedis);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.setHashKeySerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}
}
