package com.fh.controller;

import com.fh.bean.Brand;
import com.fh.service.BrandService;
import com.fh.utils.PageEntity;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("queryBrand")
@CrossOrigin(maxAge = 36000,origins = "http://localhost:8080")
public class BrandController {
@Autowired
private BrandService brandService;

    @GetMapping("/{pid}")
    public ResponseServer queryBrandsByTypeId(@PathVariable("pid") Integer pid){
        return brandService.queryBrandsByTypeId(pid);
    }



@GetMapping
    public PageEntity<Brand> queryBrand(Integer page, Integer limit, HttpServletRequest request){
        PageEntity<Brand> pageBean=new PageEntity<>(page,limit);
        return brandService.queryBrand(pageBean);
    }
    /*@GetMapping
    @RequestMapping("queryBrandPageByCateId")
    public PageEntity<Brand> queryBrandPageByCateId(Integer page, Integer limit,String categroyIds){
        PageEntity<Brand> pageBean=new PageEntity<>(page,limit);

        return brandService.queryBrandPageByCateId(pageBean,categroyIds);
    }*/


}
