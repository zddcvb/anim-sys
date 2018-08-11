package com.yanxi.anim.sys.service;

import java.util.Map;

import redis.clients.jedis.Jedis;

public interface JedisService {

	public Jedis getJedisFromPool();

	public String set(String key, String value);

	public String get(String key);

	public Long delete(String key);

	public Long incr(String key);

	public Long decr(String key);

	public Long hset(String key, String field, String value);

	public String hmset(String key, Map<String, String> map);

	public String getSet(String key, String field);

	public Map<String, String> getSet(String key);

	public Long delSet(String key, String... fields);

	public Long delSet(String key);
}
