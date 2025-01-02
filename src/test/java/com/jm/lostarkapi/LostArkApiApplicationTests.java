package com.jm.lostarkapi;

import com.jm.lostarkapi.biz.domain.boss.Expedition;
import com.jm.lostarkapi.biz.domain.boss.ExpeditionRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@RequiredArgsConstructor
class LostArkApiApplicationTests {


    @Autowired
    private ExpeditionRepository expeditionRepository;

    @Test
    void contextLoads() {
        expeditionRepository.findAllByAccountId("user1");

    }

}
