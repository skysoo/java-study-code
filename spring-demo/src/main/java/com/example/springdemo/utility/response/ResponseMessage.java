package com.example.springdemo.utility.response;

public enum ResponseMessage {
    LOGIN_OK("로그인 성공"),
    LOGIN_FAIL("로그인 실패"),
    READ_OK("조회 완료"),
    CREATE_OK("생성 완료"),
    UPDATE_OK("수정 완료"),
    DELETE_OK("삭제 완료"),
    READ_FAIL("조회 실패"),
    CREATE_FAIL("생성 실패"),
    UPDATE_FAIL("수정 실패"),
    DELETE_FAIL("삭제 실패"),
    NO_CONTENT("등록된 데이터가 없습니다."),
    NOT_FOUND_USER("조회 대상을 찾을 수 없습니다.");

    ResponseMessage(String message) {
        this.message = message;
    }

    public String message;
}
