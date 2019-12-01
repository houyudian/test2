package com.fh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpJsp {
@RequestMapping("jumpJsp")
    public String jumpJsp(String url){
        return url;
    }


}
