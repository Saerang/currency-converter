package com.saerang.currencyconverter.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConfig {

    @Value("${currency.url}")
    private String url;

    @Value("${currency.accessKey}")
    private String accessKey;

    public String getUrl() {
        return url;
    }

    public String getAccessKey() {
        return accessKey;
    }
}
