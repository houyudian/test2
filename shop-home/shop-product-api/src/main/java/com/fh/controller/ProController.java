package com.fh.controller;

import com.fh.service.ProductService;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pro")
public class ProController {
@Autowired
private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseServer getProductById(@PathVariable Integer productId){
        return productService.getProductId(productId);
    }

}
