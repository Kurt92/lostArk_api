package com.jm.lostarkapi.framework.core.exception.handling;

import com.jm.lostarkapi.framework.core.exception.BaseException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public abstract class BaseRestExceptionAdviceHandler<T> extends ResponseEntityExceptionHandler {

    /**
     * BaseException
     *
     * @param e {@link BaseException}
     * @return ErrorResponse
     */
    protected abstract ResponseEntity<T> handleBaseException(BaseException e);

    /**
     * Exception
     *
     * @param e {@link Exception}
     * @return
     */
    protected abstract ResponseEntity<T> handleException(Exception e);

    /**
     * Spring Validation Exception 처리
     *
     * <pre>
     * "@ModelAttribute" 나 "@RequestBody" 처리를 위해 데이터 바인딩 중
     * Validation 오류가 있을 경우 발생하는 Exception.
     * ConstraintViolationException 과 다르게 기본적으로 HTTP 400 오류로 처리
     *
     * # 사이트참조
     *  -. @ExceptionHandler 로 MethodArgumentNotValidException 처리 시 트러블 슈팅
     *    => https://velog.io/@u-nij/%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85-221029
     *  -. Spring Boot Validation 제대로 알고 쓰자
     *    => https://kapentaz.github.io/spring/Spring-Boo-Bean-Validation-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90/#
     * </pre>
     *
     * @param ex      the exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return
     */
    protected abstract ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request);

    /**
     * Spring Validation Exception 처리
     *
     * <pre>
     * 파라미터 혹은 리턴 값에 문제가 있을 때 발생
     * Spring에서는 이 오류를 기본적으로 HTTP 500 에러로 처리하며,
     * 사용자 요청 오류인 HTTP 400 으로 변경하고 싶다면 별도 변경 처리
     *
     * # 사이트참조
     *  -. Spring Boot Validation 제대로 알고 쓰자
     *    => https://kapentaz.github.io/spring/Spring-Boo-Bean-Validation-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90/#
     * </pre>
     *
     * @param ex
     * @param request
     * @return
     */
    protected abstract ResponseEntity<T> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request);
}