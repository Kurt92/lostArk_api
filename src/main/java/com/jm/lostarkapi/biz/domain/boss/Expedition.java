package com.jm.lostarkapi.biz.domain.boss;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table
public class Expedition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expedition_id")
    @Comment("원정대 pk")
    private Long expeditionId;

    @Column(name="account_id")
    @Comment("계정아이디")
    private Long accountId;

    @Column(name="main_character_nm")
    @Comment("대표캐릭터명")
    private String mainCharacterNm;

    @Column(name="sixman_at")
    @Comment("식스맨 여부")
    private Boolean sixmanAt;






}
