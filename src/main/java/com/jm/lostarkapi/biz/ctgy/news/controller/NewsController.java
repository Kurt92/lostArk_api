package com.jm.lostarkapi.biz.ctgy.news.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jm.lostarkapi.biz.ctgy.news.dto.NewsDto;
import com.jm.lostarkapi.biz.ctgy.news.service.NewsService;
import com.jm.lostarkapi.framework.core.response.IRestResponse;
import com.jm.lostarkapi.framework.core.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final RestTemplate restTemplate;
    private final NewsService newsService;

    @GetMapping("/event")
    public ResponseEntity<? extends IRestResponse> getEvent() {

        return RestResponse.of(newsService.findEvents());
    }

    @PutMapping("/event")
    public ResponseEntity<? extends IRestResponse> findEvent() throws Exception {

        String url = "http://localhost:8099/news/events";

        // HTTP Headers 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");

        // HttpEntity 객체에 헤더 추가
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 이렇게 하니까 바디가 링크드해쉬맵으로 들어옴
        // 이유는 오브젝트 맵퍼가 파싱할때 List.class로 명시적이지 않아서임
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );
        ObjectMapper objectMapper = new ObjectMapper();


        //이렇게 typeReference로 명시적으로 하면 맵핑 가능
        List<NewsDto.Save> res = new ArrayList<>();
//        res = objectMapper.readValue(response.getBody(), List.class);
        res = objectMapper.readValue(response.getBody(), new TypeReference<List<NewsDto.Save>>() {});
        newsService.saveEvent(res);


        // 그래서 이렇게 ParameterizedTypeReference 이렇게 하면 바로 맵핑할수 있음
//        ResponseEntity<List<NewsDto.Save>> response = restTemplate.exchange(url,
//                HttpMethod.GET,
//                entity,
//                new ParameterizedTypeReference<List<NewsDto.Save>>() {}
//        );
//        newsService.saveEvent(response.getBody());



        return RestResponse.of(HttpStatus.OK);
    }

    @GetMapping("/notice")
    public ResponseEntity<? extends IRestResponse> findNotice() {



        return new ResponseEntity<>(HttpStatus.OK);
    }

}
