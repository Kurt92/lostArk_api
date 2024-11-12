package com.jm.lostarkapi.biz.ctgy.board1.dto;

import lombok.*;

import java.time.LocalDateTime;

public class Board1Dto {


    public static class Request {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Search {
            private String title;
            private String regiestId;
            private LocalDateTime startDate;
            private LocalDateTime endDate;
        }

        public static class Save {

            private String title;
            private String content;
            private String regiDt;
            private Boolean DeleteAt;

        }

    }


    public static class Response {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Search{
            private String title;
            private String content;
            private String regiDt;
            private String comment;
            private Long like;
            private Long dislike;
            private Long viewCount;
            private String regiestId;


        }
    }


}
