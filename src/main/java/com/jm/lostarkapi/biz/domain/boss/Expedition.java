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
public class Expedition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expedition_id")
    @Comment("원정대 pk")
    private Long expeditionId;

    @Column(name="account_id")
    @Comment("계정아이디")
    private String accountId;

    @Column(name="server_nm")
    @Comment("서버명")
    private String serverNm;

    @Column(name="character_nm")
    @Comment("캐릭터명")
    private String characterNm;

    @Column(name="main_character_nm")
    @Comment("대표캐릭터명")
    private String mainCharacterNm;

    @Column(name="character_class_name")
    @Comment("캐릭터 클레스명")
    private String characterClassName;

    @Column(name="character_level")
    @Comment("캐릭터 레벨")
    private String characterLevel;

    @Column(name="item_level")
    @Comment("아이템 레벨")
    private String itemLevel;

    @Column(name="main_character_at")
    @Comment("대표캐릭터 여부")
    private Boolean mainCharacterAt;

    @Column(name="sixman_at")
    @Comment("식스맨 여부")
    private Boolean sixmanAt;



    public void updateSixmanAt(Boolean sixmanAt) {
        this.sixmanAt = sixmanAt;
    }


}
