package com.jm.lostarkapi.biz.domain.board;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    @Comment("게시물 PK")
    private Long boardId;

    @Column(name = "title")
    @Comment("내용")
    private String title;

    @Column(name = "content")
    @Comment("내용")
    private String content;

    @Column(name = "regiestId")
    @Comment("작성자ID")
    private String regiestId;

    @Column(name = "view_count")
    @Comment("조회수")
    private Long viewCount;



}
