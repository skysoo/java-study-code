package com.example.springdemo.utility.response;

public enum StatusCode {
    OK(200),
    CREATE(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),
    DB_ERROR(600);

    StatusCode(int code) {
        this.code = code;
    }

    public int code;
}
