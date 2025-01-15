package com.jm.lostarkapi.biz.ctgy.expedition.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.lostarkapi.biz.ctgy.expedition.dto.ExpeditionDto;
import com.jm.lostarkapi.biz.ctgy.expedition.service.ExpeditionService;
import com.jm.lostarkapi.biz.ctgy.news.dto.NewsDto;
import com.jm.lostarkapi.framework.core.response.IRestResponse;
import com.jm.lostarkapi.framework.core.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExpeditionController {

    private final RestTemplate restTemplate;
    private final ExpeditionService expeditionService;




    @GetMapping("/expedition/{accountId}")
    public ResponseEntity<? extends IRestResponse> findExpedition(@PathVariable String accountId) throws Exception {

        return RestResponse.of(expeditionService.findExpedition(accountId));
    }

    @PostMapping("/expedition/{accountId}")
    public ResponseEntity<? extends IRestResponse> updateSixmanAtExpedition(@PathVariable String accountId, @RequestBody ExpeditionDto.Request.updateSixmanAt updateSixmanAtDto) throws Exception {
        expeditionService.updateSixmanAtExpedition(accountId, updateSixmanAtDto);
        return RestResponse.of(HttpStatus.OK);
    }

    @PutMapping("/expedition/{name}/{accountId}")
    public ResponseEntity<? extends IRestResponse> updateExpedition(@PathVariable String name, @PathVariable String accountId) throws Exception {

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

        expeditionService.updateExpedition(name, res, accountId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
