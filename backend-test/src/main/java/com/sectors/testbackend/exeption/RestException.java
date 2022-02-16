package com.sectors.testbackend.exeption;

import lombok.Data;

@Data
public class RestException extends RuntimeException{

    private static final long serialVersionUID  = 289986815601406992L;

    private int httpStatus;
    private String errorCode;


    public RestException(String message, int httpStatus, String errorCode) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public RestException(ErrorCodes errorCode) {
        super(errorCode.getMessage());
        this.httpStatus = errorCode.getHttpStatus().value();
        this.errorCode = errorCode.getCode();
    }
}
