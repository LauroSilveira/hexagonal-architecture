package com.correia.hexagonal.domain.exception;

public class FeignClientException extends RuntimeException {
    private final Integer httpCode;

    public FeignClientException(String message, Integer httpCode) {
        super(message);
        this.httpCode = httpCode;
    }
}
