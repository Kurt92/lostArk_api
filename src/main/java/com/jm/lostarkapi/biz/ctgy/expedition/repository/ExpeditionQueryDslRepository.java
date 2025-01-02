package com.jm.lostarkapi.biz.ctgy.expedition.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jm.lostarkapi.biz.domain.boss.QExpedition.expedition;

@Repository
@RequiredArgsConstructor
public class ExpeditionQueryDslRepository {

    private final JPAQueryFactory queryFactory;



}
