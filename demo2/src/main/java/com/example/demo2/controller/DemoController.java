package com.example.demo2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 4.0 -> 5.0 인증 연동 테스트를 위한 컨트롤러.
 * 4.0 ui 서버의 역할을 한다.
 */
@Controller
public class DemoController {
    @GetMapping("/move5")
    public String loginToM5(){
        // request cert toke from .
        RestTemplate restTemplate = new RestTemplate();


        Map<String, Object> map = new HashMap<>();
        map.put("patientId","asdfqwerqwer");
        map.put("hospitalCd","11100079");
        HttpEntity requestEntity = null;
        try{
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
            final String json = new ObjectMapper().writeValueAsString(map);
            requestEntity = new HttpEntity(json, headers);
        }catch (Exception e){
            e.printStackTrace();
        }

        ResponseEntity<Map> responseEntity = null;
        String certKey = null;
        try {
            // 개발이면  https://lemoncare-dev.lemonhc.com/auth  (prperties lemoncare.routes.auth.url)
            responseEntity = restTemplate.exchange("http://localhost:18083"+"/rest/certKey", HttpMethod.POST, requestEntity, Map.class);
            System.out.println("responseEntity -> {}"+responseEntity.toString());
            certKey = (String)responseEntity.getBody().get("certKey");
        } catch (HttpClientErrorException e) {
//            httpErrorThrow(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * callbackUrl - 인증성공후 랜딩할 url
         * authorizeExceptionUrl - 인증 오류시 렌딩할 url
         */
        return "redirect:http://localhost:28084/ui/insu/sso?certKey="+certKey+"&patientId=1944026&hospitalCd=11100079&callbackUrl=/test.html&certKey&authorizeExceptionUrl=/error.html";
    }
}
