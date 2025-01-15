package com.jm.lostarkapi.biz.ctgy.boss.service;

import com.jm.lostarkapi.biz.ctgy.boss.dto.BossDto;
import com.jm.lostarkapi.biz.ctgy.boss.repository.BossQueryDslRepository;
import com.jm.lostarkapi.biz.ctgy.expedition.dto.ExpeditionDto;
import com.jm.lostarkapi.biz.domain.boss.Boss;
import com.jm.lostarkapi.biz.domain.boss.BossRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BossService {

    private final BossQueryDslRepository bossQueryDslRepository;
    private final BossRepository bossRepository;

    public List<String> findMainCharacter(String accountId) {
        return bossQueryDslRepository.findMainCharacterNm(accountId);
    }

    public List<BossDto.Response.Expeditions> findAllExpedition(String accountId) {

        List<BossDto.Expedition> expeditionList = bossQueryDslRepository.findAllExpedition(accountId);
        List<BossDto.Boss> expeditionBossList = bossQueryDslRepository.findAllExpeditionBoss(accountId);


//        List<BossDto.Expedition> updatedExpeditionList = expeditionList.stream()
//                .map(expedition -> BossDto.Expedition.builder()
//                        .accountId(expedition.getAccountId())
//                        .mainCharacterNm(expedition.getMainCharacterNm())
//                        .characterNm(expedition.getCharacterNm())
//                        .characterClassName(expedition.getCharacterClassName())
//                        .itemLevel(expedition.getItemLevel())
//                        .characterLevel(expedition.getCharacterLevel())
//                        .serverNm(expedition.getServerNm())
//                        .sixmanAt(expedition.getSixmanAt())
//                        .bossList(
//                                expeditionBossList.stream()
//                                        .filter(boss -> boss.getCharacterNm().equals(expedition.getCharacterNm()))
//                                        .collect(Collectors.toList())
//                        )
//                        .build()
//                )
//                .collect(Collectors.toList());
//
//
//        List<BossDto.Response.Expeditions> result = updatedExpeditionList.stream()
//                .collect(Collectors.groupingBy(BossDto.Expedition::getMainCharacterNm))
//                .entrySet().stream()
//                .map(entry -> BossDto.Response.Expeditions.builder()
//                        .mainCharacterNm(entry.getKey())
//                        .expeditionList(entry.getValue())
//                        .build()
//                )
//                .collect(Collectors.toList());


        //위에 스트림 두개를 하나로 합침
        List<BossDto.Response.Expeditions> result = expeditionList.stream()
                .collect(Collectors.groupingBy(BossDto.Expedition::getMainCharacterNm)) // 1차 그룹화
                .entrySet().stream()
                .map(entry -> BossDto.Response.Expeditions.builder()
                        .mainCharacterNm(entry.getKey())
                        .expeditionList(
                                entry.getValue().stream() // 2차 처리 (Expedition 매핑 및 Boss 리스트 추가)
                                        .map(expedition -> BossDto.Expedition.builder()
                                                .accountId(expedition.getAccountId())
                                                .mainCharacterNm(expedition.getMainCharacterNm())
                                                .characterNm(expedition.getCharacterNm())
                                                .characterClassName(expedition.getCharacterClassName())
                                                .itemLevel(expedition.getItemLevel())
                                                .characterLevel(expedition.getCharacterLevel())
                                                .serverNm(expedition.getServerNm())
                                                .sixmanAt(expedition.getSixmanAt())
                                                .bossList(
                                                        expeditionBossList.stream()
                                                                .filter(boss -> boss.getCharacterNm().equals(expedition.getCharacterNm()))
                                                                .collect(Collectors.toList())
                                                )
                                                .build()
                                        )
                                        .collect(Collectors.toList())
                        )
                        .build()
                )
                .collect(Collectors.toList());


        return result;
    }

    public List<BossDto.Response.BossList> findBossList() {
        List<Boss> bosses = bossRepository.findAll();

        List<BossDto.Boss> bossList = bosses.stream()
                .map(boss ->
                    BossDto.Boss.builder()
                            .bossNm(boss.getBossNm())
                            .bossCd(boss.getBossCd())
                            .bossCdGroup(boss.getBossCdGroup())
                            .gate(boss.getGate())
                            .enterLv(boss.getEnterLv())
                            .difficulty(boss.getDifficulty())
                            .clearGold(boss.getClearGold())
                            .build())
                .collect(Collectors.toList());

        List<BossDto.Response.BossList> result = bosses.stream()
                .collect(Collectors.groupingBy(item -> item.getBossNm()))
                .entrySet().stream()
                .map(entry -> BossDto.Response.BossList.builder()
                        .bossNm(entry.getKey())
                        .bossList(
                                entry.getValue().stream()
                                        .map(val -> BossDto.Boss.builder()
                                                .bossNm(val.getBossNm())
                                                .gate(val.getGate())
                                                .difficulty(val.getDifficulty())
                                                .enterLv(val.getEnterLv())
                                                .build()
                                ).collect(Collectors.toList())

                        )
                        .build())
                .collect(Collectors.toList());


        return result;
    }
}
