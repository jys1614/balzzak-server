package com.balzzak.data.exception;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class ResponseException {
    private Date timestamp;
    private String message;
    private String details;
}
