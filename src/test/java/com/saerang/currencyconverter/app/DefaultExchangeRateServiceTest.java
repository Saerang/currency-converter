package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.domain.CurrencyId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DefaultExchangeRateServiceTest {

    @Autowired
    ExchangeRateService exchangeRateService;

    @Test
    void KRW_환율_가져오기() {
        // given

        // when
        BigDecimal exchangeRate = exchangeRateService.getExchangeRate(CurrencyId.KRW);

        // then
        assertThat(exchangeRate).isNotNull();
    }

}
