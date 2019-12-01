package com.fh.controller;

import com.fh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(maxAge = 36000,origins = "http://localhost:8080")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @GetMapping
    @RequestMapping("queryMenuList")
    public List<Map<String, Object>> queryMenuList() {
        return permissionService.queryMenuList();
    }

}
