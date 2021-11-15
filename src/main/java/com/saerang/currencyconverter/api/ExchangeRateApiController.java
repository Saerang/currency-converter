package com.saerang.currencyconverter.api;

import com.saerang.currencyconverter.app.ExchangeRateService;
import com.saerang.currencyconverter.domain.CurrencyId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class ExchangeRateApiController {

    private final ExchangeRateService exchangeRateService;

    // TODO: 변환하려는 currencyId 받으면 좋음. CurrencyId enum annotation 만들면 좋음.
    @GetMapping("/api/currencies/{currencyId}/exchangeRate")
    public BigDecimal getExchangeRate(@PathVariable CurrencyId currencyId) {
        return exchangeRateService.getExchangeRate(currencyId);
    }

}
