package com.jm.lostarkapi.framework.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    /*
200 : OK, 요청 정상 처리
201 : Created, 생성 요청 성공
202 : Accepted, 비동기 요청 성공
204 : No Content, 요청 정상 처리, 응답 데이터 없음.

실패
400 : Bad Request, 요청이 부적절 할 때, 유효성 검증 실패, 필수 값 누락 등.
401 : Unauthorized, 인증 실패, 로그인하지 않은 사용자 또는 권한 없는 사용자 처리
402 : Payment Required
403 : Forbidden, 인증 성공 그러나 자원에 대한 권한 없음. 삭제, 수정시 권한 없음.
404 : Not Found, 요청한 URI에 대한 리소스 없을 때 사용.
405 : Method Not Allowed, 사용 불가능한 Method를 이용한 경우.
406 : Not Acceptable, 요청된 리소스의 미디어 타입을 제공하지 못할 때 사용.
408 : Request Timeout
409 : Conflict, 리소스 상태에 위반되는 행위 시 사용.
413 : Payload Too Large
423 : Locked
428 : Precondition Required
429 : Too Many Requests

500 : 서버 에러

     */

    /**
     * =====================================================================
     * 2xx
     * =====================================================================
     */
    OK(HttpStatus.OK, "성공", "error.code.ok"),


    /** =====================================================================
     * 4xx
     ===================================================================== */
    /**
     * 400 BAD_REQUEST : 잘못된 요청
     */
    INVALID_REQUIRE_DATA(HttpStatus.BAD_REQUEST, "요청 데이터 중 필수 데이터가 없습니다", "error.code.invalid_require_data"),
    INVALID_REQUEST_DATA(HttpStatus.BAD_REQUEST, "유효하지 않은 요청 데이터 입니다", "error.code.invalid_request_data"),
    INVALID_ACCOUNT_ID(HttpStatus.BAD_REQUEST, "유효하지 않은 계정 ID 입니다", "error.code.invalid_account_id"),
    NO_ACCOUNT_ID(HttpStatus.BAD_REQUEST, "등록된 사용자가 아닙니다", "error.code.not_user"),
    CANNOT_USED_KIOSK_ACNT(HttpStatus.BAD_REQUEST, "키오스크 계정은 사용할 수 없습니다", "error.code.cannot_used_kiosk_acnt"),
    UNSUPPORTED_LOCALE(HttpStatus.BAD_REQUEST, "지원하지 않는 로케일코드 입니다", "error.code.unsupported_locale"),
    UNSUPPORTED_ACNTSE(HttpStatus.BAD_REQUEST, "지원하지 않는 계정유형 입니다", "error.code.unsupported_acntse"),
    INVALID_COUNTRY(HttpStatus.BAD_REQUEST, "국가코드와 로케일의 국가코드가 일치하지 않습니다", "error.code.invalid_country"),
    INVALID_CPR_CODE(HttpStatus.BAD_REQUEST, "유효하지 않은 법인코드 입니다", "error.code.invalid_cpr_code"),
    INVALID_BRANCH_CODE(HttpStatus.BAD_REQUEST, "유효하지 않은 지점코드 입니다", "error.code.invalid_branch_code"),
    INVALID_BRANCH_SE(HttpStatus.BAD_REQUEST, "유효하지 않은 지점구분 입니다", "error.code.invalid_branch_se"),
    INVALID_USER(HttpStatus.BAD_REQUEST, "사용자가 일치하지 않습니다.", "error.code.invalid_user"),
    INVALID_FILE(HttpStatus.BAD_REQUEST, "업로드 가능한 파일이 아닙니다.", "error.code.invalid_file"),
    INVALID_FILE_1p5MB(HttpStatus.BAD_REQUEST, "업로드 가능한 파일이 아닙니다.(1.5mb 파일까지 가능", "error.code.invalid_file_1p5mb"),
    INVALID_EMAIL(HttpStatus.BAD_REQUEST, "유효하지 않은 이메일 입니다.", "error.code.invalid_sender_email"),
    INVALID_SENDER_EMAIL(HttpStatus.BAD_REQUEST, "유효하지 않은 발신자 메일 입니다.", "error.code.invalid_sender_email"),
    INVALID_TIME_ZONE(HttpStatus.BAD_REQUEST, "유효하지 타임존 입니다.", "error.code.invalid_time_zone"),
    UNREGISTERD_KIOSK_SERIAL(HttpStatus.BAD_REQUEST, "등록되지 않은 시리얼 번호가 있습니다", "error.code.unregisterd_kiosk_serial"),
    MISSMATCH_KIOSK_BRANCH(HttpStatus.BAD_REQUEST, "지점이 불일치 하는 키오스크가 있습니다", "error.code.missmatch_kiosk_branch"),
    SHIPPED_STATUS_KIOSK(HttpStatus.BAD_REQUEST, "출고 상태의 키오스크가 있습니다", "error.code.shipped_status_kiosk"),
    NO_SHIPPED_STATUS_KIOSK(HttpStatus.BAD_REQUEST, "미출고 상태의 키오스크가 있습니다", "error.code.no_shipped_status_kiosk"),
    MISSMATCH_REQ_AND_REAL_COUNT(HttpStatus.BAD_REQUEST, "요청과 실제 데이터의 건수가 일치하지 않습니다", "error.code.missmatch_req_and_real_count"),
    ONLY_POSSIBLE_ASSIGN_TO_HQ(HttpStatus.BAD_REQUEST, "본사(HQ)로만 할당이 가능 합니다", "error.code.only_possible_assign_to_hq"),
    ONLY_SUSPEND_STATUS_KIOSK_RETURN(HttpStatus.BAD_REQUEST, "'일시 정지' 상태의 키오스크만 반품 처리가 가능합니다", "error.code.only_suspend_status_kiosk_return"),
    ONLY_SUSPEND_STATUS_KIOSK_REMOVE(HttpStatus.BAD_REQUEST, "'일시 정지' 상태의 키오스크만 삭제 처리가 가능합니다", "error.code.only_suspend_status_kiosk_remove"),
//    SQL_DATA_RESOURCE_INVALID(HttpStatus.BAD_REQUEST, "JPA(Hibernate) SQL 오류(데이타 / 조건)","error.code."),
//    INVALID_CODE(HttpStatus.BAD_REQUEST, "유효하지 않은 HttpStatus 상태 코드 입니다","error.code."),
//    CANNOT_FOLLOW_MYSELF(HttpStatus.BAD_REQUEST, "자기 자신은 팔로우 할 수 없습니다","error.code."),
//    BAD_REQUEST(HttpStatus.BAD_REQUEST, "요청 매개변수 오류 입니다.", "error.code."),
//    MISMATCH_PASSWORD(HttpStatus.BAD_REQUEST, "비밀 번호가 일치하지 않습니다","error.code.")
    /**
     * 401 UNAUTHORIZED : 인증되지 않은 사용자
     */
//    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "권한 정보가 없는 토큰입니다", "error.code."),
//    UN_AUTHORIZED_USER(HttpStatus.UNAUTHORIZED, "계정 정보가 존재하지 않습니다", "error.code."),
    AUTHENTICATION_FAIL(HttpStatus.UNAUTHORIZED, "권한이 없습니다(인증 실패)", "error.code.authentication_fail"),
    NO_SUCH_ALGORITHM(HttpStatus.UNAUTHORIZED, "알고리즘을 찾을 수 없습니다", "error.code.no_such_algorithm"),
    AUTH_HEADER_NOT_EXISTS(HttpStatus.UNAUTHORIZED, "헤더에 인증 정보를 찾을 수 없습니다", "error.code.auth_header_not_exists"),
    //    LOGOUT_USER(HttpStatus.UNAUTHORIZED, "로그아웃된 사용자 입니다", "error.code."),
//    NOT_EXISTS_SECURITY_AUTH(HttpStatus.UNAUTHORIZED, "Security Context 에 인증 정보가 없습니다", "error.code."),
    NOT_EXISTS_TOKEN(HttpStatus.UNAUTHORIZED, "인증된 토큰이 없습니다", "error.code.not_exists_token"),
    NOT_EXISTS_TOKEN_AUTHORITY(HttpStatus.UNAUTHORIZED, "인증된 토큰에 부여된 권한이 없습니다", "error.code.not_exists_token_authority"),
    NOT_EXISTS_SAVED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "저장된 인증 토큰이 없습니다", "error.code.not_exists_saved_refresh_token"),
    //    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효한 토큰이 아닙니다","error.code."),
//    INVALID_ROLE_TOKEN(HttpStatus.UNAUTHORIZED, "사용 권한이 없는 토큰 입니다","error.code."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "토큰 유효기간이 경과 되었습니다", "error.code.expired_token"),
    INVALID_SIGN_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 서명의 토큰 입니다", "error.code.invalid_sign_token"),
    //    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "리프레시 토큰이 유효하지 않습니다","error.code."),
//    MISMATCH_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "리프레시 토큰의 유저 정보가 일치하지 않습니다","error.code."),
//    MISMATCH_REFRESH_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "발급된 refresh token의 정보가 일치하지 않습니다","error.code."),
//    NOT_EXPIRED_TOKEN_YET(HttpStatus.UNAUTHORIZED, "토큰 유효기간이 경과되지 않았습니다","error.code."),
    INVALID_TOKEN_KEY_SPEC(HttpStatus.UNAUTHORIZED, "토큰의 키 스펙이 유효하지 않습니다", "error.code.invalid_token_key_spec"),
    INVALID_TOKEN_ARGTHIM(HttpStatus.UNAUTHORIZED, "토큰 알고리즘이 유효하지 않습니다", "error.code.invalid_token_argthim"),
    UNSUPPORTED_TOKEN_PROVIDER(HttpStatus.UNAUTHORIZED, "지원하지 않는 발급자의 토큰 입니다", "error.code.unsupported_token_provider"),
    /**
     * 403 FORBIDDEN : 인증 성공 그러나 자원에 대한 권한 없음. 삭제, 수정시 권한 없음.
     */
//    FORBIDDEN(HttpStatus.FORBIDDEN, "FORBIDDEN","error.code."),
    IP_NOT_ALLOWED(HttpStatus.FORBIDDEN, "허용된 IP가 아닙니다(엑세스 거부)", "error.code.ip_not_allowed"),
    NO_RESOURCE_PERMISSION(HttpStatus.FORBIDDEN, "리소스 권한이 없습니다(엑세스 거부)", "error.code.no_resource_permission"),
    DELETED_USER(HttpStatus.FORBIDDEN, "삭제된 사용자 입니다", "error.code.deleted_user"),
    SUSPENDED_USER(HttpStatus.FORBIDDEN, "정지된 사용자 입니다", "error.code.suspended_user"),
    CHANGED_PERMESSION(HttpStatus.FORBIDDEN, "권한이 변경 되었습니다", "error.code.changed_permession"),
    CHANGED_STATUS(HttpStatus.FORBIDDEN, "상태가 변경 되었습니다", "error.code.changed_status"),
    /**
     * 404 NOT_FOUND : Resource 를 찾을 수 없음
     */
//    NOT_FOUND(HttpStatus.NOT_FOUND, "잘못된 요청 입니다", "error.code."),
//    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "파일이 존재하지 않습니다", "error.code."),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "처리 데이타 오류(처리 요청 데이터 미존재)", "error.code.data_not_found"),
    DATA_NOT_PROGRAM(HttpStatus.NOT_FOUND, "처리 데이타 오류(프로그램 데이터 미존재)", "error.code.data_not_program"),
    DATA_NOT_CPR(HttpStatus.NOT_FOUND, "처리 데이타 오류(법인 데이터 미존재)", "error.code.data_not_cpr"),
    DATA_NOT_BHF(HttpStatus.NOT_FOUND, "처리 데이타 오류(지점 데이터 미존재)", "error.code.data_not_bhf"),
    DATA_NOT_ORGNZT(HttpStatus.NOT_FOUND, "처리 데이타 오류(조직 데이터 미존재)", "error.code.data_not_orgnzt"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자 정보를 찾을 수 없습니다", "error.code.user_not_found"),
    KIOSK_NOT_FOUND(HttpStatus.NOT_FOUND, "키오스크 정보를 찾을 수 없습니다", "error.code.kiosk_not_found"),
    KIOSK_ADD_NOT_FOUND(HttpStatus.NOT_FOUND, "입고 대상이 없습니다.", "error.code.kiosk_add_not_found"),
    KIOSK_ACNTID_NOT_FOUND(HttpStatus.NOT_FOUND, "키오스크 ID를 찾을 수 없습니다.", "error.code.kiosk_acnt_not_found"),
    WAREHOUSE_BHF_NOT_FOUND(HttpStatus.NOT_FOUND, "창고(지점) 데이터를 찾을 수 없습니다", "error.code.warehouse_bhf_not_found"),
//    REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "로그아웃 된 사용자입니다", "error.code."),
//    SCRAP_DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자의 스크랩 정보를 찾을 수 없습니다", "error.code."),

    /**
     * 405 METHOD_NOT_ALLOWED : 사용 불가능한 Method를 이용한 경우
     */
    UNSUPPORTED_SERVICES(HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 서비스 입니다", "error.code.unsupported_services"),
    /**
     * 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재
     */
    SSO_DUPLICATE_ACNT(HttpStatus.CONFLICT, "[SSO]계정이 이미 등록되어 있습니다", "error.code.sso_duplicate_acnt"),
    SSO_ACCOUNT_CREATION_FAILED(HttpStatus.CONFLICT, "[SSO]계정 생성 실패", "error.code.sso_account_creation_failed"),
    SSO_ACCOUNT_PROFILE_RETRI_FAILED(HttpStatus.CONFLICT, "[SSO]계정 프로필 조회 실패", "error.code.sso_account_profile_retri_failed"),
    SSO_ACCOUNT_PROFILE_MODIFY_FAILED(HttpStatus.CONFLICT, "[SSO]계정 프로필 변경 실패", "error.code.sso_account_profile_modify_failed"),
    SSO_ACCOUNT_PWD_MODIFY_FAILED(HttpStatus.CONFLICT, "[SSO]계정 패스워드 변경 실패", "error.code.sso_account_pwd_modify_failed"),
    SSO_ACCOUNT_SCOPE_MODIFY_FAILED(HttpStatus.CONFLICT, "[SSO]계정 Scope 변경 실패", "error.code.sso_account_scope_modify_failed"),
    SSO_ACCOUNT_ADDINF_MODIFY_FAILED(HttpStatus.CONFLICT, "[SSO]계정 부가정보 변경 실패", "error.code.sso_account_addinf_modify_failed"),
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "데이터가 이미 존재합니다", "error.code.duplicate_resource"),
    SQL_DATA_INTEGRITY_VIOLATION(HttpStatus.CONFLICT, "데이터 무결성 위반", "error.code.sql_data_integrity_violation"),
    CPR_EXISTS(HttpStatus.CONFLICT, "등록되어 있는 법인 입니다", "error.code.cpr_exists"),
    CPRNM_EXISTS(HttpStatus.CONFLICT, "등록되어 있는 법인명 입니다", "error.code.cprnm_exists"),
    MEMBER_EXISTS(HttpStatus.CONFLICT, "가입되어 있는 회원 입니다", "error.code.member_exists"),
    USR_INF_ENCRYPT_FAIL(HttpStatus.CONFLICT, "사용자 정보 암호화에 실패 했습니다", "error.code.usr_inf_encrypt_fail"),
    USR_INF_DECRYPT_FAIL(HttpStatus.CONFLICT, "사용자 정보 복호화에 실패 했습니다", "error.code.usr_inf_decrypt_fail"),
    SHIPPED_KIOSK(HttpStatus.CONFLICT, "출고된 키오스크 입니다", "error.code.shipped_kiosk"),
    DESTINATION_CURRENT_SAME(HttpStatus.CONFLICT, "변경하려는 지점과 현재 지점이 동일 합니다", "error.code.destination_current_same"),
//    EMAIL_EXISTS(HttpStatus.CONFLICT, "등록되어 있는 이메일 입니다", "error.code."),


    /**
     * =====================================================================
     * 5xx
     * =====================================================================
     */
    UNDEFINED(HttpStatus.INTERNAL_SERVER_ERROR, "정의되지 않은 오류", "error.code.undefined"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "error.code.internal_server_error"),
    ACCESS_TOKEN_ISSU_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "엑세스 토큰 발행 실패", "error.code.access_token_issu_fail"),
    REFRESH_TOKEN_ISSU_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "토큰 갱신 실패", "error.code.refresh_token_issu_fail"),
    SECURE_SCOPE_NO_VALUE(HttpStatus.INTERNAL_SERVER_ERROR, "보안 Scope 입력 값 없음", "error.code.secure_scope_no_value"),
//    FAILED_DATA_RESPONSE(HttpStatus.INTERNAL_SERVER_ERROR, "실패데이터가 응답 되었습니다", "error.code."),
//    MISMATCH_REGNO(HttpStatus.INTERNAL_SERVER_ERROR, "주민번호가 일치하지 않습니다", "error.code."),


    /**
     * =====================================================================
     * 3xx, 4xx
     * 비즈니스 구분별 Error 코드 정의
     * HO: 병원, HB: 헬스뷰티, ...
     * =====================================================================
     */
    MAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "메일 정보를 찾을 수 없습니다.", "hnb.error.mail_not_found");


    private final HttpStatus httpStatus;
    private final String message;
    private final String localeMessageCd;

}