package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Brand;
import com.fh.utils.PageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface BrandDao extends BaseMapper<Brand> {

    Long queryCount();

    List<Brand> queryBrand(PageEntity<Brand> pageBean);

    Long queryCountByTypeIds(String[] ids);

    List<Brand> queryBrandByTypeIds(PageEntity<Brand> pageBean, String[] ids);

    List<Brand> queryBrandByTypeId();
}
