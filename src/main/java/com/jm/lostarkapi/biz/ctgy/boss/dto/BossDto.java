package com.jm.lostarkapi.biz.ctgy.boss.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
        private String sixmanAt;

    }
}
