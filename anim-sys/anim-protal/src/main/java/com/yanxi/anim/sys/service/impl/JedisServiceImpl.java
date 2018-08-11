package com.yanxi.anim.sys.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanxi.anim.sys.service.JedisService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class JedisServiceImpl implements JedisService {
	@Autowired
	private JedisPool jedisPool;

	public Jedis getJedisFromPool() {
		Jedis jedis = jedisPool.getResource();
		return jedis;
	}

	public String set(String key, String value) {
		Jedis jedis = getJedisFromPool();
		String set = jedis.set(key, value);
		jedis.expire(key, 300);
		return set;
	}

	public String get(String key) {
		String data = getJedisFromPool().get(key);
		return data;
	}

	public Long delete(String key) {
		Long del = getJedisFromPool().del(key);
		return del;
	}

	public Long incr(String key) {
		Long incr = getJedisFromPool().incr(key);
		return incr;
	}

	public Long decr(String key) {
		Long decr = getJedisFromPool().decr(key);
		return decr;
	}

	public Long hset(String key, String field, String value) {
		Long hset = getJedisFromPool().hset(key, field, value);
		return hset;
	}

	public String hmset(String key, Map<String, String> map) {
		String hmset = getJedisFromPool().hmset(key, map);
		return hmset;
	}

	public String getSet(String key, String field) {
		String hget = getJedisFromPool().hget(key, field);
		return hget;
	}

	public Map<String, String> getSet(String key) {
		Map<String, String> map = getJedisFromPool().hgetAll(key);
		return map;
	}

	// 根据字段删除数据，可以是多个
	public Long delSet(String key, String... fields) {
		Long hdel = getJedisFromPool().hdel(key, fields);
		return hdel;
	}

	// 删除所有
	public Long delSet(String key) {
		Long del = getJedisFromPool().del(key);
		return del;
	}
}
