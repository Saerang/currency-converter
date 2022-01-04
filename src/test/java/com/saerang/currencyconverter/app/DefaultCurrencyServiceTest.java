package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.common.BaseTest;
import com.saerang.currencyconverter.common.exception.CurrencyNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DefaultCurrencyServiceTest extends BaseTest {

    @Autowired
    CurrencyService currencyService;

    @Test
    void 환전하기() {
        // given
        // when
        BigDecimal exchangedAmount = currencyService.exchange("AAA", BigDecimal.TEN);

        // then
        assertThat(exchangedAmount).isEqualTo(new BigDecimal("10000.00"));
    }

    @Test
    void 환전하기_없는_통화() {
        // given
        // when
        // then
        assertThatThrownBy(() -> currencyService.exchange("ZZZ", BigDecimal.TEN))
                .isInstanceOf(CurrencyNotFoundException.class);
    }

    @Test
    void 환율하기() {
        // given
        // when
        BigDecimal exchangeRate = currencyService.getExchangeRate("AAA");

        // then
        assertThat(exchangeRate).isEqualTo(new BigDecimal("1000"));
    }

    @Test
    void 없는통화_환율구하기() {
        // given
        // when
        // then
        assertThatThrownBy(() -> currencyService.getExchangeRate("ZZZ"))
                .isInstanceOf(CurrencyNotFoundException.class);
    }

}
