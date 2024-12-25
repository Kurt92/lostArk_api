package com.jm.lostarkapi.biz.ctgy.expedition.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.lostarkapi.biz.ctgy.expedition.dto.ExpeditionDto;
import com.jm.lostarkapi.biz.ctgy.expedition.service.ExpeditionService;
import com.jm.lostarkapi.biz.ctgy.news.dto.NewsDto;
import com.jm.lostarkapi.framework.core.response.IRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExpeditionController {

    private final RestTemplate restTemplate;
    private final ExpeditionService expeditionService;

    @GetMapping("/expedition/{name}")
    public ResponseEntity<? extends IRestResponse> findExpedition(@PathVariable String name) throws Exception {





        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/expedition/{name}")
    public ResponseEntity<? extends IRestResponse> updateExpedition(@PathVariable String name) throws Exception {

        String url = "http://localhost:8099/expedition/" + name;

        // HTTP Headers 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");

        // HttpEntity 객체에 헤더 추가
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        ObjectMapper objectMapper = new ObjectMapper();


        List<ExpeditionDto.Save> res = new ArrayList<>();
        res = objectMapper.readValue(response.getBody(), new TypeReference<List<ExpeditionDto.Save>>() {});

//        ExpeditionDto.Save res = new ExpeditionDto.Save();
//        res.setExpeditions(objectMapper.readValue(response.getBody(), new TypeReference<List<ExpeditionDto.ExpeditionFields>>() {}));

        expeditionService.updateExpedition(name, res);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
