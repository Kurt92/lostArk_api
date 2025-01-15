package com.jm.lostarkapi.biz.ctgy.boss.controller;

import com.jm.lostarkapi.biz.ctgy.boss.service.BossService;
import com.jm.lostarkapi.framework.core.response.IRestResponse;
import com.jm.lostarkapi.framework.core.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boss")
public class BossController {

    private final BossService bossService;


    @GetMapping("/main-character/{accountId}")
    public ResponseEntity<? extends IRestResponse> findMainCharacter(@PathVariable String accountId) {

        return RestResponse.of(bossService.findMainCharacter(accountId));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<? extends IRestResponse> findAllExpedition(@PathVariable String accountId) {

        return RestResponse.of(bossService.findAllExpedition(accountId));
    }

    @GetMapping("/list")
    public ResponseEntity<? extends IRestResponse> findBossList() {

        return RestResponse.of(bossService.findBossList());
    }

    @GetMapping
    public ResponseEntity<? extends IRestResponse> findUser() {

        return new ResponseEntity<>(null);
    }
}
