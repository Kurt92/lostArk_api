package com.jm.lostarkapi.biz.ctgy.boss.controller;

import com.jm.lostarkapi.framework.core.response.IRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boss")
public class BossController {



    @GetMapping
    public ResponseEntity<? extends IRestResponse> findUser() {

        return new ResponseEntity<>(null);
    }
}
