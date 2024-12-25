package com.jm.lostarkapi.biz.ctgy.expedition.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class ExpeditionDto {


    public static class Response {
        private List<ExpeditionDto.ExpeditionFields> expeditions;
    }

    @Setter
    public static class Save extends ExpeditionFields {

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExpeditionFields {
        @JsonProperty("ServerName")
        private String serverName;
        @JsonProperty("CharacterName")
        private String characterName;
        @JsonProperty("CharacterLevel")
        private String characterLevel;
        @JsonProperty("CharacterClassName")
        private String characterClassName;
        @JsonProperty("ItemAvgLevel")
        private String itemAvgLevel;
        @JsonProperty("ItemMaxLevel")
        private String itemMaxLevel;
    }

}
