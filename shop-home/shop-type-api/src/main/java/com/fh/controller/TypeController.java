package com.fh.controller;

import com.fh.redis.RedisService;
import com.fh.service.TypeService;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("queryType")
@CrossOrigin(maxAge = 36000, origins = "http://localhost:8080")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private RedisService redisService;

    @GetMapping
    public ResponseServer queryType() {
        List<Map<String,Object>> treeData=typeService.queryTypeList();

        /*//先查缓存再去查数据库
        Boolean isExistKey = redisService.isExistKey("typeAll");
        Object typeList = null;
        if (!isExistKey) {
            typeList = typeService.queryTypeList();

            redisService.setStringKeyAndValue("typeAll", typeList);
        } else {
            typeList = redisService.getStringValueByKey("typeAll");
        }*/

        return ResponseServer.success(treeData);
    }

}
