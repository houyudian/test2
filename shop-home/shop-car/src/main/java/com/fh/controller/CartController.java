package com.fh.controller;

import com.fh.bean.Cart;
import com.fh.login.LoginAnnotation;
import com.fh.service.CartService;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/carts")
@CrossOrigin(maxAge = 3600, origins = "http://localhost:8080", exposedHeaders = "NOLONGIN")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("addCart")
    @LoginAnnotation
    public ResponseServer addCart(Integer productId, HttpServletRequest request) {
        String userPhone = (String) request.getAttribute("phone");
        /*  userPhone = "13561326533";*/
        return cartService.addCart(productId, userPhone);
    }

    @GetMapping("lookCarts")
    @LoginAnnotation
    public ResponseServer lookCarts() {

        return ResponseServer.success();
    }

    @LoginAnnotation
    @GetMapping("cartShow")
    public ResponseServer cartShow(HttpServletRequest request) {
        String phone = (String) request.getAttribute("phone");
        Map<String, Object> carts = cartService.getCarts(phone);
        return ResponseServer.success(carts);
    }

    @LoginAnnotation
    @PostMapping("/updataNum")
    public ResponseServer changeNum(Integer productId, HttpServletRequest request) {

        String phone = (String) request.getAttribute("phone");
        cartService.changeNum(productId, phone);
        return ResponseServer.success();

    }

    @LoginAnnotation
    @PostMapping("/changCheck")
    public ResponseServer changChecked(Integer productId, HttpServletRequest request) {

        String phone = (String) request.getAttribute("phone");
        cartService.updateCheckedStatus(productId, phone);
        return ResponseServer.success();

    }

    @LoginAnnotation
    @PostMapping("/cartCheck")
    public ResponseServer cartCheck(Integer productId, HttpServletRequest request) {
        String phone = (String) request.getAttribute("phone");
        String cartId = (String) redisTemplate.opsForValue().get("cartid_" + phone);
        Cart cart = (Cart) redisTemplate.opsForHash().get(cartId, productId);
        if (cart.getIsChecked()) {
            cart.setIsChecked(false);
        } else {
            cart.setIsChecked(true);
        }
        redisTemplate.opsForHash().put(cartId, productId, cart);
        return ResponseServer.success();
    }

}
