package com.saerang.currencyconverter.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Currency {

    private final CurrencyId currencyId;

    private final BigDecimal exchangeRate;

    public Currency(CurrencyId currencyId, BigDecimal exchangeRate) {
        this.currencyId = currencyId;
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangedMoney(BigDecimal money) {
        return money.multiply(this.exchangeRate).setScale(currencyId.getScale(), RoundingMode.FLOOR);
    }

}
