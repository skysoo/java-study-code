package com.example.springdemo.utility.response;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ResponseHandler {
    public DefaultResponse<Object> createResponse(Object object, HttpServletRequest request){
        DefaultResponse<Object> response = null;
        int statusCode = 0;
        String message = null;

        switch (request.getMethod()){
            case "POST":
                if (object!=null){
                    statusCode = StatusCode.OK.code;
                    message = ResponseMessage.CREATE_OK.message;
                } else {
                    statusCode = StatusCode.INTERNAL_SERVER_ERROR.code;
                    message = ResponseMessage.CREATE_FAIL.message;
                }
                break;
            case "PUT":
                if (object!=null){
                    statusCode = StatusCode.OK.code;
                    message = ResponseMessage.UPDATE_OK.message;
                } else {
                    statusCode = StatusCode.INTERNAL_SERVER_ERROR.code;
                    message = ResponseMessage.UPDATE_FAIL.message;
                }
                break;
            case "GET":
                if (object!=null){
                    statusCode = StatusCode.OK.code;
                    message = ResponseMessage.READ_OK.message;
                } else {
                    statusCode = StatusCode.NO_CONTENT.code;
                    message = ResponseMessage.READ_FAIL.message;
                }
                break;
            case "DELETE":
                if (Boolean.parseBoolean(String.valueOf(object))){
                    statusCode = StatusCode.OK.code;
                    message = ResponseMessage.DELETE_OK.message;
                } else {
                    statusCode = StatusCode.INTERNAL_SERVER_ERROR.code;
                    message = ResponseMessage.DELETE_FAIL.message;
                }
                break;
        }

        return DefaultResponse.builder()
                .data(object)
                .statusCode(statusCode)
                .reponseMessage(message)
                .build();
    }
}
