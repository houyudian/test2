package com.fh.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtils<httpClient> {

    private static CloseableHttpClient httpClient;

    static {
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(5000).setSocketTimeout(15000).build();
            //创建Http请求的客户端
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
    }

    public static String doPost(String url, Map<String, String> parameterMap) {

        HttpPost httpPost = new HttpPost(url);

        if (parameterMap != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();

            parameterMap.entrySet().forEach(entry -> {

                String key = entry.getKey();
                String value = entry.getValue();
                list.add(new BasicNameValuePair(key, value));

            });
            try {
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
                httpPost.setEntity(urlEncodedFormEntity);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            return EntityUtils.toString(entity, "UTF-8");

        } catch (HttpHostConnectException e) {
            e.printStackTrace();
            //服务器连接超时异常
            return JSON.toJSONString(ResponseServer.error(ServerEnum.SERVER_CONNECT_ERROR));
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return JSON.toJSONString(ResponseServer.error(ServerEnum.SERVER_BUSYNESS));
        } catch (IOException e) {
            e.printStackTrace();
            return JSON.toJSONString(ResponseServer.error(ServerEnum.SERVER_ERROR));
        } finally {
            if (response != null) {

                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String doGet(String url) {

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");

        } catch (HttpHostConnectException e) {
            e.printStackTrace();
            //服务器连接超时异常
            return JSON.toJSONString(ResponseServer.error(ServerEnum.SERVER_CONNECT_ERROR));
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return JSON.toJSONString(ResponseServer.error(ServerEnum.SERVER_BUSYNESS));
        } catch (IOException e) {
            e.printStackTrace();
            return JSON.toJSONString(ResponseServer.error(ServerEnum.SERVER_ERROR));
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String doPut(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Put请求
            HttpPut httpPut = new HttpPut(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPut.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPut);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {

        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {

            }
        }

        return resultString;
    }

    public static String doDelete(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建Http Delete请求
            HttpDelete httpDelete = new HttpDelete(uri);
            // 执行http请求
            response = httpClient.execute(httpDelete);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {

        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {

            }
        }

        return resultString;
    }
}
