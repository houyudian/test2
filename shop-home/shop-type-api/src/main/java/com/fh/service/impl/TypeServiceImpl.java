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
    public List<Map<String, Object>> queryTypeList() {
      List<Type>  typeList=typeDao.queryType();
        return getType(0,typeList);

    }

    private List<Map<String, Object>> getType(Integer pid, List<Type> typeList) {
        List<Map<String, Object>> list = new ArrayList<>();
        typeList.forEach(type -> {
            Map<String, Object> map = null;
            if (pid.equals(type.getPid())) {
                map = new HashMap<>();
                map.put("id", type.getId());
                map.put("name", type.getName());
                map.put("pid", type.getPid());
                map.put("children", getType(type.getId(), typeList));
            }
            if (map != null) {
                list.add(map);
            }
        });
        return list;
    }
}
