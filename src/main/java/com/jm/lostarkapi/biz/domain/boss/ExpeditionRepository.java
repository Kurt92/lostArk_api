package com.jm.lostarkapi.biz.domain.boss;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ExpeditionRepository extends CrudRepository<Expedition, Long> {


    List<Expedition> findAllByMainCharacterNm(String mainCharacterNm);
    List<Expedition> findAllByAccountId(String accountId);
}
