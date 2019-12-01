package com.fh.service.impl;

import com.fh.bean.Type;
import com.fh.dao.TypeDao;
import com.fh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    @Override
    public List<Map<String, Object>> queryType() {
        List<Type> list = typeDao.queryTypeTree();
        return getTreeList(0, list);
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeDao.getTypeById(id);
    }

    @Override
    public void addType(Type category) {
        if(category.getId() != null){
            typeDao.updateType(category);
        }else{
            typeDao.insert(category);
        }

    }

    private List<Map<String, Object>> getTreeList(Integer pid, List<Type> list) {
        List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
        list.forEach(type -> {
            Map<String, Object> map = null;
            if (pid.equals(type.getPid())) {
                map = new HashMap<>();
                map.put("id", type.getId());
                map.put("name", type.getName());
                map.put("pid", type.getPid());
                map.put("children", getTreeList(type.getId(), list));
            }
            if (map != null) {
                treeList.add(map);
            }
        });
        return treeList;
    }

}
