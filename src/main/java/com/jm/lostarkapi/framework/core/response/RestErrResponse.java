package com.jm.lostarkapi.framework.core.response;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jm.lostarkapi.framework.core.exception.BaseException;
import com.jm.lostarkapi.framework.core.exception.ErrorCode;
import com.jm.lostarkapi.framework.core.util.Checks;
import com.jm.lostarkapi.framework.core.util.gson.LocalDateTimeTypeAdapter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

//@JacksonXmlRootElement(localName = "result")
@Slf4j
@Getter
@Builder
@ToString
public class RestErrResponse<T> implements IRestResponse, Serializable {
    private static final long SerialVersionUID = 1L;

    private final boolean success = false;

    private final LocalDateTime timestamp = LocalDateTime.now();

    private final int status;

    private final String error;

    private final String code;
    @Setter
    private String message;
    private T details;

    public static ResponseEntity<RestErrResponse> of(ErrorCode errorCode) {
        RestErrResponse errorResponse = getErrorResponse(errorCode);
        printErrorResponse(errorResponse);

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(errorResponse);
    }

    public static <T> ResponseEntity<RestErrResponse> of(ErrorCode errorCode, T details) {
        RestErrResponse errorResponse = getErrorResponse(null, errorCode, details);
        printErrorResponse(errorResponse);

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(errorResponse);
    }

    public static <T> ResponseEntity<RestErrResponse> of(ErrorCode errorCode, String message, T details) {
        RestErrResponse errorResponse = getErrorResponse(message, errorCode, details);
        printErrorResponse(errorResponse);

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(errorResponse);
    }

    public static ResponseEntity<RestErrResponse> of(BaseException e) {
        RestErrResponse errorResponse = null;

        if (Checks.isNotEmpty(e.getErrorCode())) {
            errorResponse = getErrorResponse(e.getMessage(), e.getErrorCode());

        } else {
            errorResponse = RestErrResponse.builder()
                    .status(e.getHttpStatus().value())
                    .error(e.getHttpStatus().name())
                    .code(Checks.isNotEmpty(e.getErrorCode()) ? e.getErrorCode().name() : StringUtils.EMPTY)
                    .message(Checks.isNotEmpty(e.getLocalizedMessage()) ? e.getLocalizedMessage() : e.getLocalizedMessage())
                    .build();
        }
        printErrorResponse(errorResponse);

        return ResponseEntity
                .status(e.getHttpStatus())
                .body(errorResponse);
    }

//    public static ResponseEntity<RestErrResponse> of(String code, String message) {
//        return of(code, message, null);
//    }

//    public static <T> ResponseEntity<RestErrResponse> of(String code, String message, T data) {
//        RestErrResponse errorResponse = RestErrResponse.builder()
//                .status(HttpStatus.BAD_REQUEST.value())
//                .error(HttpStatus.BAD_REQUEST.name())
//                .code(code)
//                .message(message)
//                .data(data)
//                .build();
//        printErrorResponse(errorResponse);
//
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(errorResponse);
//    }


    protected static RestErrResponse getErrorResponse(ErrorCode errorCode) {
        return getErrorResponse(null, errorCode, null);
    }

    protected static RestErrResponse getErrorResponse(String message, ErrorCode errorCode) {
        return getErrorResponse(message, errorCode, null);
    }

    public static <T> RestErrResponse getErrorResponse(String message, ErrorCode errorCode, T details) {
        return RestErrResponse.builder()
                .status(errorCode.getHttpStatus().value())
                .error(errorCode.getHttpStatus().name())
                .code(errorCode.name())
                .message(message == null ? errorCode.getMessage() : message)
                .details(details)
                .build();
    }

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
            .create();

    public String toJson() {
        return gson.toJson(this);
    }

    private static void printErrorResponse(RestErrResponse errorResponse) {
        log.error("##############################################################################################");
        log.error("{}", errorResponse);
        log.error("##############################################################################################");
    }
}