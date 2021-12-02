package com.saerang.currencyconverter.api;

import com.saerang.currencyconverter.app.CurrencyService;
import com.saerang.currencyconverter.common.CommonUtils;
import com.saerang.currencyconverter.domain.Currency;
import com.saerang.currencyconverter.common.validation.CurrencyId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyApiController {

    final private CurrencyService currencyService;

    @GetMapping("/currencies")
    public String test() {
        return "test";
    }

    @GetMapping("/currencies/{currencyId}/exchange")
    public String exchange(@PathVariable("currencyId") @CurrencyId String currencyId, @RequestParam BigDecimal amount) {
        return CommonUtils.getResponseDecimalFormat(currencyService.exchange(currencyId, amount));
    }

    @GetMapping("/currencies/{currencyId}")
    public Currency getCurrency(@PathVariable @CurrencyId String currencyId) {
        return currencyService.getCurrency(currencyId);
    }

    @GetMapping("/currencies/{currencyId}/exchangeRate")
    public String getExchangeRate(@PathVariable @CurrencyId String currencyId) {
        return CommonUtils.getResponseDecimalFormat(currencyService.getExchangeRate(currencyId));
    }

}
