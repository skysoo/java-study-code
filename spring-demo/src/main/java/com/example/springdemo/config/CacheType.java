package com.example.springdemo.config;

import lombok.Getter;

/**
 * users - 사용자 리스트를 제공하는 API 는 30분 마다 갱신된다.
 * user_info - 사용자 한명에 대한 데이터를 제공하는 API 는 한번 DB에 저장되면 수정되지 않는다.
 **/
@Getter
public enum CacheType {
    USERS("userList",5*60, 10000),
    USER_INFO("userInfo",24*60*60, 10000);

    CacheType(String cachename, int expiredAfterWrite, int maximumSize) {
        this.cachename = cachename;
        this.expiredAfterWrite = expiredAfterWrite;
        this.maximumSize = maximumSize;
    }

    private String cachename;
    private int expiredAfterWrite;
    private int maximumSize;
}
