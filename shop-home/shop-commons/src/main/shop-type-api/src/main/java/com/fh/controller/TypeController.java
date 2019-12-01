package com.fh.controller;

import com.fh.bean.Type;
import com.fh.redis.RedisService;
import com.fh.service.TypeService;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

   /* @GetMapping
    public ResponseServer queryType() {
        //先查缓存再去查数据库
        Boolean isExistKey = redisService.isExistKey("typeAll");
        Object typeList = null;
        if (!isExistKey) {
            typeList = typeService.queryType();
            redisService.setStringKeyAndValue("typeAll", typeList);
        } else {
            typeList = redisService.getStringValueByKey("typeAll");
        }
        return ResponseServer.success(typeList);
    }*/
  @GetMapping
    public ResponseServer queryType() {
        List<Map<String, Object>> treeData = typeService.queryType();
        return ResponseServer.success(treeData);
    }

    /**
     * 查询根据类型信息
     *
     * @param id
     * @return
     */
    @GetMapping
    @RequestMapping("toTypeEdit")
    public ModelAndView toTypeEdit(Integer id) {
        ModelAndView mav = new ModelAndView("typeEdit");
        Type type = new Type();

        if (id != null) {
            type = typeService.getTypeById(id);
        }
        mav.addObject("categroy", type);
        return mav;
    }

    /**
     * 增加类型
     *
     * @return
     */
    @RequestMapping("addType")
    @ResponseBody
    public ResponseServer addType(Type category) {
        typeService.addType(category);
        return ResponseServer.success(category);
    }
}
