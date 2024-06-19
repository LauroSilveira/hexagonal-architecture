package com.correia.hexagonal.domain.exception;

public class BusinessException extends RuntimeException {
    private String message;
    private Integer httpCode;

    public BusinessException(Integer httpCode, String message) {
        super(message);
        this.httpCode = httpCode;
    }
}
