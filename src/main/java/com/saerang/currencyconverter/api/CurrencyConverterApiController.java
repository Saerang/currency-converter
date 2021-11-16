package com.saerang.currencyconverter.api;

import com.saerang.currencyconverter.app.CurrencyConverterService;
import com.saerang.currencyconverter.common.CommonUtils;
import com.saerang.currencyconverter.domain.CurrencyId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CurrencyConverterApiController {

    final private CurrencyConverterService currencyConverterService;

    @GetMapping("/api/currencies/{currencyId}/conversion")
    public String conversion(@PathVariable("currencyId") CurrencyId currencyId, @RequestParam BigDecimal money) {
        return CommonUtils.getResponseDecimalFormat(currencyConverterService.getConvertedMoney(currencyId, money));
    }

}
