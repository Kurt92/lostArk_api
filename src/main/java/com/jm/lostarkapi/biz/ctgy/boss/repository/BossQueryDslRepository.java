package com.jm.lostarkapi.biz.ctgy.boss.repository;

import com.jm.lostarkapi.biz.ctgy.boss.dto.BossDto;
import com.jm.lostarkapi.biz.ctgy.expedition.dto.ExpeditionDto;
import com.jm.lostarkapi.biz.domain.boss.QExpeditionFriend;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jm.lostarkapi.biz.domain.boss.QExpedition.expedition;
import static com.jm.lostarkapi.biz.domain.boss.QExpeditionFriend.expeditionFriend;

@Repository
@RequiredArgsConstructor
public class BossQueryDslRepository {

    private final JPAQueryFactory queryFactory;


    public List<String> findMainCharacterNm(String accountId) {
        return queryFactory
                .select(expedition.mainCharacterNm)
                .from(expedition)
                .where(expedition.accountId.eq(accountId))
                .groupBy(expedition.mainCharacterNm)
                .fetch();
    }

    public List<BossDto.Expedition> findAllExpedition(String accountId) {

        QExpeditionFriend ef1 = new QExpeditionFriend("ef1");
        QExpeditionFriend ef2 = new QExpeditionFriend("ef2");

        List<BossDto.Expedition> expeditionList = queryFactory
                .selectDistinct(
                        Projections.fields(
                                BossDto.Expedition.class,
                                expedition.accountId,
                                expedition.mainCharacterNm,
                                expedition.characterNm,
                                expedition.characterLevel,
                                expedition.characterClassName,
                                expedition.itemLevel,
                                expedition.serverNm
                        )
                )
                .from(expedition)
                .leftJoin(ef1).on(ef1.friendAccountId.eq(expedition.accountId))
                .leftJoin(ef2).on(ef2.myAccountId.eq(expedition.accountId))
                .where(
                        expedition.accountId.eq(accountId)
                                .or(ef1.myAccountId.eq(accountId))
                                .or(ef2.friendAccountId.eq(accountId))
                )
                .fetch();


        return expeditionList;
    }
}
