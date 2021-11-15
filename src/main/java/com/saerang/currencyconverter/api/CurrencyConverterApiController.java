package com.saerang.currencyconverter.api;

import com.saerang.currencyconverter.app.CurrencyConverterService;
import com.saerang.currencyconverter.domain.CurrencyId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CurrencyConverterApiController {

    final private CurrencyConverterService currencyConverterService;

    // TODO: 변환하려는 currencyId 받으면 좋음. CurrencyId enum annotation 만들면 좋음.
    @GetMapping("/api/currencies/{currencyId}/conversion")
    public BigDecimal conversion(@PathVariable("currencyId") CurrencyId currencyId, @RequestParam BigDecimal money) {
        return currencyConverterService.getConvertedMoney(currencyId, money);
    }

}
