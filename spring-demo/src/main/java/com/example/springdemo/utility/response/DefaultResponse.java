package com.example.springdemo.utility.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DefaultResponse<T> {
    private int statusCode;
    private String reponseMessage;
    private T data;

    @Builder
    public DefaultResponse(int statusCode, String reponseMessage, T data) {
        this.statusCode = statusCode;
        this.reponseMessage = reponseMessage;
        this.data = data;
    }
}
