package com.yanxi.anim.sys.utils;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ImageUtilTest {

	@Test
	public void test() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		JedisPool jedisPool = new JedisPool(poolConfig, "192.168.145.128", 6379);
		Jedis jedis = jedisPool.getResource();
		// System.out.println(jedis.get("name"));
		
		System.out.println(jedis == null);
		jedis.set("age", "20");
	}
}
