package com.jm.lostarkapi.biz.ctgy.board1.service;


import com.jm.lostarkapi.biz.ctgy.board1.dto.Board1Dto;
import com.jm.lostarkapi.biz.ctgy.board1.repository.Board1QueryDslRepository;
import com.jm.lostarkapi.biz.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Board1Service {

    private final BoardRepository boardRepository;
    private final Board1QueryDslRepository board1QueryDslRepository;


    @Transactional
    public List<Board1Dto.Response.Search> sample1() {

        List<Board1Dto.Response.Search> result = new ArrayList<>();
        result = board1QueryDslRepository.sample1();

        return result;
    }

}
