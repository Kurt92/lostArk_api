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

    @Column(name = "expedition_id")
    @Comment("원정대 pk")
    private Long expeditionId;

    @Column(name="my_account_id")
    @Comment("내계정아이디")
    private String myAccountId;

    @Column(name="friend_account_id")
    @Comment("친구계정아이디")
    private String friendAccountId;
}
