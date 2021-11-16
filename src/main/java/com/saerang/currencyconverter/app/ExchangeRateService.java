package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.domain.CurrencyId;

import java.math.BigDecimal;

public interface ExchangeRateService {

    BigDecimal getExchangeRate(CurrencyId currencyId);

}
