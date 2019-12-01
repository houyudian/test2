package com.fh.controller;

import com.fh.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProController {


    @RequestMapping("/queryProduct")
    @ResponseBody
    Map queryProduct(){
        ModelMap result=new ModelMap();
        String url = "http://localhost:8090/queryProduct";
        String str = HttpClientUtils.doGet(url);
        System.out.println(str);
        result.put("a",str);
        return result;
    }

    @RequestMapping(value = "queryList",method = RequestMethod.GET)
    @ResponseBody
    Map queryList(){
        Map map=new HashMap();
       /* List<Shop> shop = shopService.queryList();
        map.put("data",shop);*/
        return map;
    }
}
