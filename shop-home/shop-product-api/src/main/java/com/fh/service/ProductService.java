package com.fh.service;

import com.fh.bean.Pro;
import com.fh.bean.ProductParamter;
import com.fh.utils.PageBean;
import com.fh.utils.ResponseServer;

public interface ProductService {

    PageBean<Pro> queryProduct(PageBean<Pro> page, ProductParamter paramter);

    ResponseServer getProductId(Integer productId);
}
