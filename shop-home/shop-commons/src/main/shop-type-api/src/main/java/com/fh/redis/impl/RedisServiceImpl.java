package com.fh.redis.impl;

import com.fh.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("redisService")
public class RedisServiceImpl implements RedisService {
    @Autowired
private RedisTemplate redisTemplate;

    @Override
    public Boolean isExistKey(String typeAll) {
        return redisTemplate.hasKey(typeAll);
    }

    @Override
    public void setStringKeyAndValue(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public Object getStringValueByKey(String typeAll) {
        return redisTemplate.opsForValue().get(typeAll);
    }
}
