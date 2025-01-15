package com.jm.lostarkapi.biz.ctgy.boss.dto;

import lombok.*;

import java.util.List;

public class BossDto {

    public static class Request {

        public static class User {

        }

    }

    public static class Response {

        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Friend {
            private String accountId;
            private String myAccountAt;
        }

        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Expeditions {
            private String mainCharacterNm;
//            private Boolean myCharacterAt;
            private List<BossDto.Expedition> expeditionList;
        }

        @Getter
        @Setter
        @Builder
        public static class BossList {

            private String bossNm;
            private List<BossDto.Boss> bossList;

        }

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Expedition {
        private String accountId;
        private String mainCharacterNm;
        private String characterNm;
        private String characterClassName;
        private String itemLevel;
        private String characterLevel;
        private String serverNm;
        private Boolean sixmanAt;
        private List<BossDto.Boss> bossList;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Boss {
        private Long expeditionBossId;
        private String characterNm;
        private String bossNm;
        private String bossCd;
        private String bossCdGroup;
        private String gate;
        private Boolean clearAt;
        private Long clearGold;
        private String difficulty;
        private String enterLv;

    }
}
