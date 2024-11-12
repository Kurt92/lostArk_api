package com.jm.lostarkapi.framework.core.response;

import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@SuppressWarnings("rawtypes")
public class RestResponse<T> implements IRestResponse, Serializable {
    private static final long SerialVersionUID = 1L;

    private final static String SUCCESS = "200";
    private final static String NOT_FOUND = "400";
    private final static String FAILED = "500";
    private final static String SUCCESS_MESSAGE = "SUCCESS";
    private final static String NOT_FOUND_MESSAGE = "NOT FOUND";
    private final static String FAILED_MESSAGE = "서버에서 오류가 발생하였습니다.";

    private boolean success = true;

//    @Schema(name = "데이타 수", description = "API 실행 결과 데이타 수")
//    private int count;

    //    @Schema(name = "메세지", description = "API 실행 결과 메시지")
//    private RestMessage message;
    private String code;
    private String message;
    private T data;
//
//    @Schema(name = "페이징 정보", description = "페이징 정보")
//    private Paginator paginator;

    private RestResponse() {

    }

    private RestResponse(T data) {
//        this.message = new RestMessage(SUCCESS, SUCCESS_MESSAGE);
        this.code = SUCCESS;
        this.message = SUCCESS_MESSAGE;
        this.data = data;

        if (data == null) {
//            this.count = 0;

        } else {
            // Pageing 처리
            if (Page.class.isAssignableFrom(data.getClass())) {

                Page page = (Page) data;

                //noinspection unchecked
                this.data = (T) page.getContent();
//                this.paginator = new Paginator(page.getPageable().getPageNumber(), page.getSize(), Integer.parseInt(String.valueOf(page.getTotalElements())));// paginator.getTotalPages

//                this.count = paginator.getTotalCount();

            } else {
//                if (Collection.class.isAssignableFrom(data.getClass())) {
//                    this.count = (((Collection<?>) data).size());
//
//                } else {
//                    this.count = 1;
//                }
            }
        }
    }

    public static <T> ResponseEntity<? extends IRestResponse> ok() {
        return ResponseEntity.ok().body(new RestResponse<>(null));
    }

    public static <T> ResponseEntity<? extends IRestResponse> of(T data) {
        return ResponseEntity.ok().body(new RestResponse<>(data));
    }

    public static <T> ResponseEntity<? extends IRestResponse> of(String name, T data) {
        Map<String, T> map = new HashMap<>();
        map.put(name, data);
        return ResponseEntity.ok().body(new RestResponse<>(map));
    }

    public static <T> ResponseEntity<? extends IRestResponse> of(HttpStatus httpStatus) {
        RestResponse result = new RestResponse();
//        result.message = new RestMessage(SUCCESS, SUCCESS_MESSAGE);
        result.code = SUCCESS;
        result.message = SUCCESS_MESSAGE;
        return new ResponseEntity<>(result, httpStatus);
    }

    public static <T> ResponseEntity<? extends IRestResponse> of(String message, HttpStatus httpStatus) {
        RestResponse result = new RestResponse();
//        result.message = new RestMessage(SUCCESS, SUCCESS_MESSAGE);
        result.code = SUCCESS;
        result.message = message;
        return new ResponseEntity<>(result, httpStatus);
    }

    public static <T> ResponseEntity<? extends IRestResponse> of(T data, HttpStatus httpStatus) {
        RestResponse result = new RestResponse();
//        result.message = new RestMessage(SUCCESS, SUCCESS_MESSAGE);
        result.code = SUCCESS;
        result.data = data;
        return new ResponseEntity<>(result, httpStatus);
    }

    @Override
    public String toString() {
        GsonBuilder builder = new GsonBuilder().serializeNulls();       // value가 null값인 경우도 생성
        builder.disableHtmlEscaping();
        return builder.setPrettyPrinting().create().toJson(this);
    }
}