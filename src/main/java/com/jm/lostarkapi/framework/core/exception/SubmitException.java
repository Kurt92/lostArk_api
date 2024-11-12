package com.jm.lostarkapi.framework.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid parameter")
public class SubmitException extends RuntimeException {
    private ErrorCode errorCode;

    public SubmitException() {
        super();
    }

    public SubmitException(String msg) {
        super(msg);
    }

    public SubmitException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public SubmitException(ErrorCode errorCode, Throwable e) {
        super(errorCode.getMessage(), e);
        this.errorCode = errorCode;
    }

    public SubmitException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public SubmitException(ErrorCode errorCode, String msg, Throwable e) {
        super(msg, e);
        this.errorCode = errorCode;
    }

    public SubmitException(Throwable e) {
        super(e);
    }

    public SubmitException(String msg, Throwable cause) {
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
