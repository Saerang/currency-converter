package com.saerang.currencyconverter.app.dto;

import com.saerang.currencyconverter.domain.CurrencyId;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyResponseTest {

    @Test
    void 환율_계산_가져오기() {
        // given
        Map<String, BigDecimal> quotes = new HashMap<>();
        BigDecimal krw = new BigDecimal("1179.089912");
        quotes.put("USDKRW", krw);

        CurrencyResponse currencyResponse = new CurrencyResponse(true, null, "USD", quotes);

        // when
        BigDecimal exchangeRate = currencyResponse.getExchangeRate(CurrencyId.KRW);

        // then
        assertThat(exchangeRate).isEqualTo(krw);
    }

}
