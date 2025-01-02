package com.jm.lostarkapi.biz.domain.boss;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table
public class ExpeditionFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expedition_friend_id")
    @Comment("원정대 친구 pk")
    private Long expeditionFriendId;

//    @Column(name = "expedition_id")
//    @Comment("원정대 pk")
//    private Long expeditionId;

    @Column(name="my_account_id")
    @Comment("내계정아이디")
    private String myAccountId;

    @Column(name="friend_account_id")
    @Comment("친구계정아이디")
    private String friendAccountId;


    // 친구 관계를 위한 FK 매핑
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "expedition_id")
//    private Expedition expedition;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "friend_expedition_id")
//    private Expedition friendExpedition;
}
