package com.jm.lostarkapi.biz.ctgy.board1.repository;

import com.jm.lostarkapi.biz.ctgy.board1.dto.Board1Dto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jm.lostarkapi.biz.domain.board.QBoard.board;


@Repository
@RequiredArgsConstructor
public class Board1QueryDslRepository {
    private final JPAQueryFactory queryFactory;


    public List<Board1Dto.Response.Search> sample1() {
        return queryFactory
                .select(
                        Projections.fields(
                                Board1Dto.Response.Search.class,
                                board.boardId,
                                board.content,
                                board.regiestId,
                                board.viewCount
                        )
                )
                .from(board)
                .fetch();
    }

}
