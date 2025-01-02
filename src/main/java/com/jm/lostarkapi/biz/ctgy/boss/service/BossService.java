package com.jm.lostarkapi.biz.ctgy.boss.service;

import com.jm.lostarkapi.biz.ctgy.boss.dto.BossDto;
import com.jm.lostarkapi.biz.ctgy.boss.repository.BossQueryDslRepository;
import com.jm.lostarkapi.biz.ctgy.expedition.dto.ExpeditionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BossService {

    private final BossQueryDslRepository bossQueryDslRepository;

    public List<String> findMainCharacter(String accountId) {
        return bossQueryDslRepository.findMainCharacterNm(accountId);
    }

    public List<BossDto.Response.Expeditions> findAllExpedition(String accountId) {

        List<BossDto.Expedition> expeditionList = bossQueryDslRepository.findAllExpedition(accountId);

        List<BossDto.Response.Expeditions> result = expeditionList.stream()
                .collect(Collectors.groupingBy(BossDto.Expedition::getMainCharacterNm))
                .entrySet().stream()
                .map(entry -> BossDto.Response.Expeditions.builder()
                        .mainCharacterNm(entry.getKey())
                        .expeditionList(entry.getValue())
                        .build()
                )
                .collect(Collectors.toList());


        return result;
    }
}
