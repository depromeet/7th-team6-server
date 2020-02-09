package com.depromeet.unibet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "C001", "유효하지 않는 값입니다."),
    BET_NOT_EXIST(400, "M002", "존재하지 않는 목입표니다."),
    METHOD_NOT_ALLOWED(405, "C002", "유효하지 않은 접근입니다."),
    COMMNET_NOT_EXIST(410, "M003", "유효하지 않은 댓글입니다.");

    private int status;
    private final String code;
    private final String message;
}