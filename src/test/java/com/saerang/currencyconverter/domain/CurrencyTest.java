package com.saerang.currencyconverter.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyTest {

    @Test
    void 한국_환율정보_생성() {
        // given
        CurrencyId currencyId = CurrencyId.KRW;

        // when
        Currency currency = new Currency(currencyId, new BigDecimal("1119.93"));

        // then
        assertThat(currency.getCurrencyId()).isEqualTo(currencyId);
    }

    @Test
    void 환율정보_변환된_돈가져오기() {
        // given
        BigDecimal inputMoney = new BigDecimal("100");
        CurrencyId currencyId = CurrencyId.KRW;
        Currency currency = new Currency(currencyId, new BigDecimal("1119.93"));

        // when
        BigDecimal exchangedMoney = currency.getExchangedMoney(inputMoney);

        // then
        assertThat(exchangedMoney).isEqualTo(new BigDecimal("111993.00"));
    }

}
