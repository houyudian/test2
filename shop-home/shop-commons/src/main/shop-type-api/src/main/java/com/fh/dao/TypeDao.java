package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface TypeDao extends BaseMapper<Type> {
    List<Type> queryTypeTree();

    Type getTypeById(Integer id);

    void updateType(Type category);
}
