package com.saerang.currencyconverter.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AbstractBaseException.class)
    protected ResponseEntity<ErrorResponse> handleApiException(AbstractBaseException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(
                        new ErrorResponse(
                                e.getHttpStatus().value(),
                                e.getHttpStatus().getReasonPhrase(),
                                e.getMessage()
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> exception(Exception e) {
        log.error("Error: {} \n " +
                        "HttpStatus: {} {}\n" +
                        "Message: {}"
                , e, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new ErrorResponse(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                                e.getLocalizedMessage()
                        )
                );
    }

}
