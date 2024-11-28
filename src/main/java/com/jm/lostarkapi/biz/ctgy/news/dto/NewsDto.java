package com.jm.lostarkapi.biz.ctgy.news.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

public class NewsDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class Response {
        private List<NewsDto.NewsFields> events;
    }

    @Getter
    public static class Save extends NewsFields { }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true) //정의되지 않은 필드 무시
    public static class NewsFields {
        @JsonProperty("Title")
        private String title;
        @JsonProperty("Thumbnail")
        private String bannerImgUrl;
        @JsonProperty("Link")
        private String linkUrl;
    }
}
