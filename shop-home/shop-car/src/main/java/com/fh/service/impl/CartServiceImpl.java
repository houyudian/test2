package com.fh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.bean.Cart;
import com.fh.httpClient.HttpConnection;
import com.fh.service.CartService;
import com.fh.utils.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResponseServer addCart(Integer productId, String userPhone) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get("cartid_" + userPhone);
        //根据商品id查询商品信息
        String url = "http://localhost:8060/pro/" + productId;
        String result = HttpConnection.doGet(url);
        JSONObject json = JSON.parseObject(result);
        System.out.println(json.get("data"));
        JSONObject productData = JSON.parseObject(json.get("data").toString());

        //讲数据加入购物车实体bean中
        Cart car = new Cart();
        car.setProductId(productData.getInteger("id"));
        car.setProductName(productData.getString("name"));
        car.setMainImg(productData.getString("mainImg"));
        car.setPrice(productData.getBigDecimal("price"));

        //判断商品是否存在购物车
        if (redisTemplate.opsForHash().hasKey(cartId, productId)) {
            Cart cart = (Cart) redisTemplate.opsForHash().get(cartId, productId);
            car.setCount(cart.getCount() + 1);
        } else {
            car.setCount(1);
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(0.00);
        BigDecimal count = new BigDecimal(car.getCount());
        BigDecimal subtotal = bigDecimal.add(car.getPrice()).multiply(count);

        car.setSubtotal(subtotal);
        car.setIsChecked(true);

//加入到redis
        redisTemplate.opsForHash().put(cartId, productId, car);
        Long cartCount = redisTemplate.opsForHash().size(cartId);
        return ResponseServer.success(cartCount);
    }

    @Override
    public Map<String, Object> getCarts(String phone) {
        //获取购物车的id
        String cartId = (String) redisTemplate.opsForValue().get("cartid_" + phone);
        //取出购物车数据
        List<Cart> cartList =redisTemplate.opsForHash().values(cartId);
        BigDecimal bigDecimal = BigDecimal.valueOf(0.00);
        for (Cart cart:cartList){
            if(cart.getIsChecked()){}
            bigDecimal = bigDecimal.add(cart.getSubtotal());
        }
        Map<String, Object> map=new HashMap<>();
        map.put("cartList",cartList);
        map.put("total",bigDecimal);
        return map;
    }

    @Override
    public void changeNum(Integer productId, String phone) {
        String cartId = (String) redisTemplate.opsForValue().get("cartid_" + phone);

        Cart cart = (Cart) redisTemplate.opsForHash().get(cartId, productId);
        cart.setCount(cart.getCount() + 1);
        cart.setSubtotal(cart.getPrice().multiply(new BigDecimal(cart.getCount())));
        redisTemplate.opsForHash().put(cartId, productId, cart);
    }

    @Override
    public void updateCheckedStatus(Integer productId, String phone) {

        String cartId = (String) redisTemplate.opsForValue().get("cartid_" + phone);
        Cart cart = (Cart) redisTemplate.opsForHash().get(cartId, productId);
        cart.setIsChecked(!cart.getIsChecked());

        redisTemplate.opsForHash().put(cartId,productId,cart);
    }

}
