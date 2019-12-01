package com.fh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @GetMapping
    @RequestMapping("jumpJsp")
    @CrossOrigin(maxAge = 36000,origins = "http://localhost：8080")
    public String jumpJsp(String url) {
        return url;
    }




}
