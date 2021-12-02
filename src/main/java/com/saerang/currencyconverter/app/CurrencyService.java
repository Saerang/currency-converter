package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.domain.Currency;

import java.math.BigDecimal;

public interface CurrencyService {

    BigDecimal exchange(String currencyId, BigDecimal amount);

    BigDecimal getExchangeRate(String currencyId);

    Currency getCurrency(String currencyId);

}
