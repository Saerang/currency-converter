package com.saerang.currencyconverter.common.exception;

import org.springframework.http.HttpStatus;

public class CurrencyNotFoundException extends AbstractBaseException{

    public CurrencyNotFoundException() {
        this("Currency not found.", null);
    }

    public CurrencyNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.CURRENCY_NOF_FOUND;
    }
}
