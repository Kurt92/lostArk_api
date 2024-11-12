package com.jm.lostarkapi.framework.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid parameter")
public class BaseException extends RuntimeException {
    private ErrorCode errorCode;
    private List<String> details;

    public BaseException() {
        super();
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, Throwable e) {
        super(errorCode.getMessage(), e);
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, List<String> details) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.details = details;
    }

    public BaseException(ErrorCode errorCode, String msg, Throwable e) {
        super(msg, e);
        this.errorCode = errorCode;
    }

    public BaseException(Throwable e) {
        super(e);
    }

    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }


    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
