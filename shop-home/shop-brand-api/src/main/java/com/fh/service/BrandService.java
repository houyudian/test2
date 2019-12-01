package com.fh.service;

import com.fh.bean.Brand;
import com.fh.utils.PageEntity;
import com.fh.utils.ResponseServer;

public interface BrandService {
    PageEntity<Brand> queryBrand(PageEntity<Brand> pageBean);

    PageEntity<Brand> queryBrandPageByCateId(PageEntity<Brand> pageBean, String categroyIds);

    ResponseServer queryBrandsByTypeId(Integer pid);
}
