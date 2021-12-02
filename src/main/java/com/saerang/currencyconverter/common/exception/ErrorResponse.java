package com.saerang.currencyconverter.common.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    private int httpStatus;

    private String errorMessage;

    private String detailMessage;

    private Errors errors;

    @Getter
    @NoArgsConstructor
    public static class Errors {

        private List<Body> body;

        @Builder
        public Errors(List<Body> body) {
            this.body = body;
        }

        @Getter
        @NoArgsConstructor
        public static class Body {
            private String message;

            @Builder
            public Body(String message) {
                this.message = message;
            }
        }
    }

    public ErrorResponse(int httpStatus, String errorMessage, String detailMessage) {
        super();
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.detailMessage = detailMessage;

        Errors.Body body = Errors.Body.builder().message(detailMessage).build();
        this.errors = Errors.builder().body(List.of(body)).build();
    }
}
