package com.saerang.currencyconverter.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyTest {

    @Test
    void 커런시정보가져오기() {
        // given
        String currencyId = "AAA";
        int scale = 2;
        BigDecimal exchangeRate = new BigDecimal("1000");

        // when
        Currency currency = new Currency(currencyId, scale, exchangeRate);

        // then
        assertThat(currency.getCurrencyId()).isEqualTo(currencyId);
        assertThat(currency.getExchangeRate()).isEqualTo(exchangeRate);
        assertThat(currency.getScale()).isEqualTo(scale);
    }

    @Test
    void 환전금액_계산() {
        // given
        Currency currency = new Currency("AAA", 2, new BigDecimal("1000"));

        // when
        BigDecimal exchange = currency.getExchange(new BigDecimal("100"));

        // then
        assertThat(exchange).isEqualTo(new BigDecimal("100000.00"));
    }
}
