package com.jm.lostarkapi.biz.domain.news;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private long newsId;

    @Column(name="title")
    @Comment("타이틀")
    private String title;

    @Column(name="banner_img_url")
    @Comment("베너 이미지 url")
    private String bannerImgUrl;

    @Column(name="link_url")
    @Comment("링크 url")
    private String linkUrl;

    @Column(name="endAt")
    @Comment("종료여부")
    private Boolean endAt;


}
