package com.saerang.currencyconverter.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saerang.currencyconverter.domain.Currency;
import com.saerang.currencyconverter.app.enumerate.CurrencyInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponseDto {
    private boolean success;

    private String terms;

    private String source;

    private Map<String, BigDecimal> quotes;

    private Map<String, Object> error;

    public CurrencyResponseDto(boolean success, String terms, String source, Map<String, BigDecimal> quotes) {
        this(success, terms, source, quotes, null);
    }

    public CurrencyResponseDto(boolean success, String terms, String source, Map<String, BigDecimal> quotes, Map<String, Object> error) {
        this.success = success;
        this.terms = terms;
        this.source = source;
        this.quotes = quotes;
        this.error = error;
    }

    public List<Currency> toEntities() {
        return quotes.entrySet().stream()
                .filter(e -> CurrencyInfo.isCurrencyId(e.getKey().replace(this.source, "")))
                .map(e -> {
                    String code = e.getKey().replace(this.source, "");
                    CurrencyInfo currencyInfo = CurrencyInfo.valueOf(code);
                    return new Currency(code, currencyInfo.getScale(), e.getValue());
                }).collect(Collectors.toList());
    }

}
