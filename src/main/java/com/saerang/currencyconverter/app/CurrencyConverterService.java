package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.domain.CurrencyId;

import java.math.BigDecimal;

public interface CurrencyConverterService {

    BigDecimal getConvertedMoney(CurrencyId currencyId, BigDecimal money);

}
