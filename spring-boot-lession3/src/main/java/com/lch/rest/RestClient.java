package com.lch.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RestClient
 * @Description TODO
 * @Authod lichanghong
 * @Date 2018/8/20 10:26
 **/
public class RestClient {
    public static void main(String[] args) {
        final String url = "http://localhost/1/dc/permission/getPermission";
        RestTemplate restTemplate = new RestTemplate();
        //设置header
        HttpHeaders headers = new HttpHeaders();
        //设置token
        headers.add("accessToken", "ef4e3a2b-ae21-4cad-ada8-86ec46a8a83g");
        String result = restTemplate.postForObject(url, new HttpEntity<String>(headers), String.class);
        System.out.println(result);
    }
}
