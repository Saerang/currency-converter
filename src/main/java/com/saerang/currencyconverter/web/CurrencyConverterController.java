package com.saerang.currencyconverter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyConverterController {

    @GetMapping("/currencyConverter")
    public String currencyConverter() {
        return "currency-converter";
    }
}
