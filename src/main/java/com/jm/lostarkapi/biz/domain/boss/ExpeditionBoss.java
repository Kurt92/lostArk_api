package com.jm.lostarkapi.biz.domain.boss;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class ExpeditionBoss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expedition_boss_id")
    @Comment("원정대 pk")
    private Long expeditionBossId;

    @Column(name = "boss_cd")
    @Comment("보스코드")
    private String bossCd;

    @Column(name = "account_id")
    @Comment("계정아이디")
    private String accountId;

    @Column(name = "main_character_nm")
    @Comment("대표캐릭터명")
    private String mainCharacterNm;

    @Column(name = "character_nm")
    @Comment("캐릭터명")
    private String characterNm;

    @Column(name = "clear_at")
    @Comment("클리어여부")
    private Boolean clearAt;




}
