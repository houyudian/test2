package com.fh.redis;

public interface RedisService {


    void setStringKeyAndValue(String key, Object value);

    Boolean isExistKey(String typeAll);

    Object getStringValueByKey(String typeAll);
}
