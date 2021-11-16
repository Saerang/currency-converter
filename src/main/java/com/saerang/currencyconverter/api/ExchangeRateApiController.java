package com.saerang.currencyconverter.api;

import com.saerang.currencyconverter.app.ExchangeRateService;
import com.saerang.currencyconverter.common.CommonUtils;
import com.saerang.currencyconverter.domain.CurrencyId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateApiController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/api/currencies/{currencyId}/exchangeRate")
    public String getExchangeRate(@PathVariable CurrencyId currencyId) {
        return CommonUtils.getResponseDecimalFormat(exchangeRateService.getExchangeRate(currencyId));
    }

}
