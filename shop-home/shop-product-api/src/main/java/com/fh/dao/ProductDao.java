package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Pro;
import com.fh.bean.Product;
import com.fh.bean.ProductParamter;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductDao extends BaseMapper<Product> {

    long queryCount(@Param("paramter") ProductParamter paramter);

    List<Pro> queryProduct(@Param("page") PageBean<Pro> page,@Param("paramter") ProductParamter paramter);

    Product queryProductById(Integer productId);
}
