package com.saerang.currencyconverter.common.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends AbstractBaseException{

    public InternalServerErrorException() {
        this("Internal Server Error", null);
    }

    public InternalServerErrorException(Throwable e) {
        this("Internal Server Error", e);
    }

    public InternalServerErrorException(String msg, Throwable e) {
        super(msg, e);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.INTERNAL_ERROR;
    }
}
