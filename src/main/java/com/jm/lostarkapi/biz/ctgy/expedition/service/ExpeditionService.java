package com.jm.lostarkapi.biz.ctgy.expedition.service;


import com.jm.lostarkapi.biz.ctgy.expedition.dto.ExpeditionDto;
import com.jm.lostarkapi.biz.domain.boss.Expedition;
import com.jm.lostarkapi.biz.domain.boss.ExpeditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpeditionService {

    private final ExpeditionRepository expeditionRepository;


    public void updateExpedition(String mainCharacterNm, List<ExpeditionDto.Save> res) {

        List<Expedition> savedExpeditionList = expeditionRepository.findAllByMainCharacterNm(mainCharacterNm);

        Map<String, Expedition> savedExpedition = savedExpeditionList.stream()
                .collect(Collectors.toMap(
                        Expedition::getCharacterNm,
                        expedition -> expedition
                ));

        List<Expedition> updateExpeditions = res.stream()
                .map(resItem -> {
                    Expedition exist = savedExpedition.get(resItem.getCharacterName());
                    if (exist == null) {
                        return Expedition.builder()
                                .serverNm(resItem.getServerName())
                                .characterNm(resItem.getCharacterName())
                                .mainCharacterNm(mainCharacterNm)
                                .characterLevel(resItem.getCharacterLevel())
                                .itemLevel(resItem.getItemAvgLevel())
                                .characterClassName(resItem.getCharacterClassName())
                                .accountId(null)
                                .mainCharacterAt(mainCharacterNm.equals(resItem.getCharacterClassName()))
                                .sixmanAt(false)
                                .build();
                    } else if (!Objects.equals(exist.getCharacterNm(), resItem.getCharacterName()) ||
                                !Objects.equals(exist.getCharacterLevel(), resItem.getItemMaxLevel())
                                ) {
                        return Expedition.builder()
                                .expeditionId(exist.getExpeditionId())
                                .serverNm(resItem.getServerName())
                                .characterNm(resItem.getCharacterName())
                                .mainCharacterNm(mainCharacterNm)
                                .characterLevel(resItem.getCharacterLevel())
                                .itemLevel(resItem.getItemAvgLevel())
                                .characterClassName(resItem.getCharacterClassName())
                                .accountId(null)
                                .mainCharacterAt(mainCharacterNm.equals(resItem.getCharacterClassName()))
                                .sixmanAt(exist.getSixmanAt())
                                .build();
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .toList();


        if (!updateExpeditions.isEmpty()) {
            expeditionRepository.saveAll(updateExpeditions);
        }


    }

}
