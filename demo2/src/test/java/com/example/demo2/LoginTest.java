package com.example.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

public class LoginTest {
    @Test
    public void testLogin(){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("grant_type", "password");
        multiValueMap.add("username", "{\"appId\":2,\"authType\":\"SIMPLE\",\"userAccount\":\"insu\",\"userId\":242481,\"loginType\":\"PIN\",\"uuid\":\"bc75c808103aa1fd\",\"userNm\":\"양시혁\"}");
        multiValueMap.add("password", "000000");

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("lemoncare@lemonhc.com", "P@ssw0rd");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> restParams = new HttpEntity<>(multiValueMap, headers);
        ResponseEntity<Map> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange("http://localhost:18083/oauth/token", HttpMethod.POST, restParams, Map.class);
            System.out.println("responseEntity-> " +responseEntity.toString());
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
//            httpErrorThrow(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void randomTest(){
        System.out.println(UUID.randomUUID().toString());

    }
}
