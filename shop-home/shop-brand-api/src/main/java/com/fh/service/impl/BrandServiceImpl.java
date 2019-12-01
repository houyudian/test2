package com.fh.service.impl;

import com.fh.bean.Brand;
import com.fh.dao.BrandDao;
import com.fh.service.BrandService;
import com.fh.utils.PageEntity;
import com.fh.utils.ResponseServer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BrandDao brandDao;
    @Override
    public PageEntity<Brand> queryBrand(PageEntity<Brand> pageBean) {
        Long count= brandDao.queryCount();
        pageBean.setCount(count);
        List<Brand> brandList=brandDao.queryBrand(pageBean);
        pageBean.setData(brandList);
        return pageBean;
    }

    @Override
    public PageEntity<Brand> queryBrandPageByCateId(PageEntity<Brand> pageBean, String categroyIds) {
        if(StringUtils.isNotBlank(categroyIds)){
            String[] ids=categroyIds.split(",");
            Long count=brandDao.queryCountByTypeIds(ids);
            pageBean.setCount(count);
            List<Brand> brandList=brandDao.queryBrandByTypeIds(pageBean,ids);
            pageBean.setData(brandList);
        }

        return pageBean;
    }

    @Override
    public ResponseServer queryBrandsByTypeId(Integer pid) {
        List<Brand> brands= brandDao.queryBrandByTypeId();
        List<Brand> returnList= brands.stream()
                .filter(brand->brand.getCategroyId().equals(pid))
                .collect(Collectors.toList());
        return ResponseServer.success(returnList);
    }

   /* @Override
    public ResponseServer queryBrandsByCateId(Integer pid) {
        Boolean isExistBrand=redisTemplate.hasKey("brands");
        List<Brand> brands=new ArrayList<>();
        if(isExistBrand){
            brandBeans= (List<Brand>) redisTemplate.opsForValue().get("brands");
        }else{
            brands=brandDao.queryBrandByTypeId();
            redisTemplate.opsForValue().set("brands",brandBeans);
        }
        //
        List<Brand> returnList= brandBeans.stream()
                .filter(brand->brand.getCategoryId().equals(pid))
                .collect(Collectors.toList());
        return ResponseServer.success(returnList);
    }*/
}
