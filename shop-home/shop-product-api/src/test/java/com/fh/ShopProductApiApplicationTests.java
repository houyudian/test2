package com.fh;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;

public class ShopProductApiApplicationTests {

    @Test
    public void contextLoads() {
        Map<String, Object> headerMap = new HashMap<String, Object>();

        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("phone", "13561326533");
        payload.put("userId", "2");
        Long iat = System.currentTimeMillis();

        payload.put("exp",iat+600001);
        payload.put("iat",iat);


        String toKey= Jwts.builder()
                .setHeader(headerMap)
                .setPayload(JSON.toJSONString(payload))
                .signWith(SignatureAlgorithm.HS256,getSecretKey("huahua"))
                .compact();
        System.out.print(toKey);


    }
    @Test
    public void resolverTest(){
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyIiOjE1NzQ3ODk1MjU1NDcsImlhdCI6MTU3NDc4ODkyNTU0NiwicGhvbmUiOiIxMzU2MTMyNjUzMyIsInVzZXJJZCI6IjIifQ.WftzUW-xuCPxgkzZYh_3Siy-ETvqmJ9gPNR0YujyUZg";
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getSecretKey("huahua"))
                    .parseClaimsJws(token)
                    .getBody();

        }catch (ExpiredJwtException exp){
            System.out.println("token超时，token失效了");
        }catch (SignatureException sing){
            System.out.println("token解析失败");
        }

    }



    private  static String getSecretKey(String key){
        return new BASE64Encoder().encode(key.getBytes());
    }
}
