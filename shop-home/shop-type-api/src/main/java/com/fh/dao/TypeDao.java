package com.fh.dao;

import com.fh.bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDao {

    List<Type> queryType();
}
