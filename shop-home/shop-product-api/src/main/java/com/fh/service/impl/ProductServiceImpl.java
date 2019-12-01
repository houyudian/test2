package com.fh.service.impl;

import com.fh.bean.Pro;
import com.fh.bean.Product;
import com.fh.bean.ProductParamter;
import com.fh.dao.ProductDao;
import com.fh.service.ProductService;
import com.fh.utils.PageBean;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public PageBean<Pro> queryProduct(PageBean<Pro> page, ProductParamter paramter) {
        //查询总条数
        Long count=productDao.queryCount(paramter);
        page.setRecordsFiltered(count);
        page.setRecordsTotal(count);
        //查询分页数据
        List<Pro> productList=productDao.queryProduct(page,paramter);
        page.setData(productList);
        return page;
    }

    @Override
    public ResponseServer getProductId(Integer productId) {

     Product product= productDao.queryProductById(productId);
        return ResponseServer.success(product);
    }

    /*@Override
    public PageBean<Pro> queryProduct(PageBean<Pro> page) {
        long count = productDao.queryCount();
      page.setRecordsFiltered(count);
      page.setRecordsTotal(count);
        List<Pro> productList = productDao.queryProduct(page);
        page.setData(productList);
        return page;
    }*/

}
