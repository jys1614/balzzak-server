package com.balzzak.data.exception;

import lombok.Getter;

@Getter
public class ResponseError {
    private String errorCode;
    private String errorMessage;

    public ResponseError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
