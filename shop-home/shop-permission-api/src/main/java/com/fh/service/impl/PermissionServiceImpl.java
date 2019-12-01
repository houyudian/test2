package com.fh.service.impl;

import com.fh.dao.PermissionDao;
import com.fh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.bean.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {
   @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Map<String, Object>> queryMenuList() {
        List<Permission> permissionList= permissionDao.selectList(null);
        return getPermissionTree(0,permissionList);
    }

    private List<Map<String, Object>> getPermissionTree(Integer pid, List<Permission> permissionList) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        permissionList.forEach(permission -> {
            Map<String, Object> map = null;
            if (pid.equals(permission.getPid())) {
                map = new HashMap<>();
                map.put("id", permission.getId());
                map.put("name", permission.getName());
                map.put("curl", permission.getUrl());
                map.put("iconUrl", permission.getIconUrl());
                map.put("children", getPermissionTree(permission.getId(), permissionList));
            }
            if (map != null) {
                list.add(map);
            }
        });

        return list;


    }

}
