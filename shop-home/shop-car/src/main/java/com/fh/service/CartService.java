package com.fh.service;

import com.fh.utils.ResponseServer;

import java.util.Map;

public interface CartService {


    ResponseServer addCart(Integer productId, String userPhone);

    Map<String, Object> getCarts(String phone);

    void changeNum(Integer productId, String phone);

    void updateCheckedStatus(Integer productId, String phone);
}
