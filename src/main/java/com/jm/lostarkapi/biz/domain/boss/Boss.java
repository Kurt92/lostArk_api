package com.jm.lostarkapi.biz.domain.boss;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boss_id")
    @Comment("원정대 pk")
    private Long bossId;

    @Column(name="boss_nm")
    @Comment("보스명")
    private String bossNm;

    @Column(name="boss_cd")
    @Comment("보스코드")
    private String bossCd;

    @Column(name="gete")
    @Comment("관문")
    private String gete;

    @Column(name="clear_gold")
    @Comment("클리어골드")
    private int clearGold;

}
