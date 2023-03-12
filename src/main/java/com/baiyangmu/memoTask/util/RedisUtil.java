package com.baiyangmu.memotask.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储数据到 Redis 中
     * @param key 键
     * @param value 值
     * @param expireTime 过期时间，单位：秒
     */
    public void set(String key, Object value, long expireTime) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 获取 Redis 中存储的数据
     * @param key 键
     * @return 存储的值
     */
    public Object get(String key) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

    /**
     * 删除 Redis 中存储的数据
     * @param key 键
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
