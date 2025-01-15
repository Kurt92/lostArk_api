package com.jm.lostarkapi.biz.ctgy.boss.repository;

import com.jm.lostarkapi.biz.ctgy.boss.dto.BossDto;
import com.jm.lostarkapi.biz.ctgy.expedition.dto.ExpeditionDto;
import com.jm.lostarkapi.biz.domain.boss.QExpeditionFriend;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jm.lostarkapi.biz.domain.boss.QBoss.boss;
import static com.jm.lostarkapi.biz.domain.boss.QExpedition.expedition;
import static com.jm.lostarkapi.biz.domain.boss.QExpeditionBoss.expeditionBoss;
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
                                expedition.serverNm,
                                expedition.sixmanAt
                        )
                )
                .from(expedition)
                .leftJoin(ef1).on(ef1.friendAccountId.eq(expedition.accountId))
                .leftJoin(ef2).on(ef2.myAccountId.eq(expedition.accountId))
//                .leftJoin(expeditionBoss).on(expedition.characterNm.eq(expeditionBoss.characterNm))
//                .leftJoin(boss).on(expeditionBoss.bossCd.eq(boss.bossCd))
                .where(
                        expedition.accountId.eq(accountId)
                                .or(ef1.myAccountId.eq(accountId))
                                .or(ef2.friendAccountId.eq(accountId)),
                        expedition.sixmanAt.isTrue()
                )
                .fetch();


        return expeditionList;
    }

    public List<BossDto.Boss> findAllExpeditionBoss(String accountId) {

        QExpeditionFriend ef1 = new QExpeditionFriend("ef1");
        QExpeditionFriend ef2 = new QExpeditionFriend("ef2");

        List<BossDto.Boss> expeditionBossList = queryFactory
                .selectDistinct(
                        Projections.fields(
                                BossDto.Boss.class,
                                expeditionBoss.expeditionBossId,
                                expeditionBoss.characterNm,
                                expeditionBoss.clearAt,
                                boss.bossNm,
                                boss.gate,
                                boss.clearGold,
                                boss.bossCd,
                                boss.bossCdGroup
                        )
                )
                .from(expeditionBoss)
                .leftJoin(ef1).on(ef1.friendAccountId.eq(expeditionBoss.accountId))
                .leftJoin(ef2).on(ef2.myAccountId.eq(expeditionBoss.accountId))
                .leftJoin(boss).on(expeditionBoss.bossCd.eq(boss.bossCd))
                .where(
                    expeditionBoss.accountId.eq(accountId)
                            .or(ef1.myAccountId.eq(accountId))
                            .or(ef2.friendAccountId.eq(accountId))
                )
                .fetch();

        return expeditionBossList;
    }

}
