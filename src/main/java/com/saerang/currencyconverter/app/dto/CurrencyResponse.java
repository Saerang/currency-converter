package com.saerang.currencyconverter.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saerang.currencyconverter.domain.CurrencyId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {
    private boolean success;

    private String terms;

    private String source;

    private Map<String, BigDecimal> quotes;

    private Map<String, Object> error;

    public CurrencyResponse(boolean success, String terms, String source, Map<String, BigDecimal> quotes) {
        this(success, terms, source, quotes, null);
    }

    public CurrencyResponse(boolean success, String terms, String source, Map<String, BigDecimal> quotes, Map<String, Object> error) {
        this.success = success;
        this.terms = terms;
        this.source = source;
        this.quotes = quotes;
        this.error = error;
    }

    public BigDecimal getExchangeRate(CurrencyId currencyId) {
        return this.quotes.get(source + currencyId);
    }

}
