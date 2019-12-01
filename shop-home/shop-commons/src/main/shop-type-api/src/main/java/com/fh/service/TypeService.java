package com.fh.service;

import com.fh.bean.Type;

import java.util.List;
import java.util.Map;

public interface TypeService {
    List<Map<String, Object>> queryType();

    Type getTypeById(Integer id);

    void addType(Type category);
}
