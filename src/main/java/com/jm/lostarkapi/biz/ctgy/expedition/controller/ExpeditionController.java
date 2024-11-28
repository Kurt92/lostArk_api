package com.jm.lostarkapi.biz.ctgy.expedition.controller;

import com.jm.lostarkapi.biz.ctgy.expedition.service.ExpeditionService;
import com.jm.lostarkapi.framework.core.response.IRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class ExpeditionController {

    private final RestTemplate restTemplate;
    private final ExpeditionService expeditionService;

    @GetMapping("/expedition/{name}")
    public ResponseEntity<? extends IRestResponse> findExpedition(@PathVariable String name) {
        String url = "http://localhost:8099/api-test/" + name;

        // HTTP Headers 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");

        // HttpEntity 객체에 헤더 추가
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);



        expeditionService.saveExpedition();


        return new ResponseEntity<>(null);
    }

    @PutMapping("/expedition")
    public ResponseEntity<? extends IRestResponse> updateExpedition() {



        return new ResponseEntity<>(null);
    }

}
