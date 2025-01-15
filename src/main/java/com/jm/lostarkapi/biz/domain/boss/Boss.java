package com.jm.lostarkapi.biz.domain.boss;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boss_id")
    @Comment("보스 pk")
    private Long bossId;

    @Column(name="boss_nm")
    @Comment("보스명")
    private String bossNm;

    @Column(name="boss_cd")
    @Comment("보스코드")
    private String bossCd;

    @Column(name="boss_cd_group")
    @Comment("보스코드그룹")
    private String bossCdGroup;

    @Column(name="difficulty")
    @Comment("난이도")
    private String Difficulty;

    @Column(name="gate")
    @Comment("관문")
    private String gate;

    @Column(name="enter_lv")
    @Comment("입장레벨")
    private String enterLv;

    @Column(name="clear_gold")
    @Comment("클리어골드")
    private Long clearGold;

}
