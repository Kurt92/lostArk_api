package com.jm.lostarkapi.framework.core.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RestMessage {
    private String code;
    private String message;
}