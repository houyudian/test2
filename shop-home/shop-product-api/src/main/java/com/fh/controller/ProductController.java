package com.fh.controller;

import com.fh.bean.Pro;
import com.fh.bean.ProductParamter;
import com.fh.service.ProductService;
import com.fh.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 36000,origins = "http://localhost:8080")
@RequestMapping("queryProduct")
public class ProductController {

    @Autowired
    private ProductService productService;




  /*  @GetMapping
    public PageBean<Pro> queryProduct(Integer page, Integer limit){
        PageBean<Pro> pageBean=new PageBean<Pro>(page,limit);
        return productService.queryProduct(pageBean);
    }*/

    @PostMapping
    public PageBean<Pro> queryProductList(PageBean<Pro> page, ProductParamter paramter){
        page=productService.queryProduct(page,paramter);
        return page;
    }


}
