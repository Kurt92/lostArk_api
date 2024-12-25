package com.jm.lostarkapi.biz.ctgy.news.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jm.lostarkapi.biz.domain.news.QEvent.event;

@Repository
@RequiredArgsConstructor
public class NewsQueryDslRepository {

    private final JPAQueryFactory queryFactory;


    public void updateAllEndAtToTrue (List<Long> savedIds) {

        queryFactory.update(event)
                .set(event.endAt, true)
                .where(event.newsId.notIn(savedIds))
                .execute();

    }

}
