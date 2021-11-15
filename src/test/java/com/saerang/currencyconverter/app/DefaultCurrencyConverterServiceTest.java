package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.domain.CurrencyId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DefaultCurrencyConverterServiceTest {

    @Mock
    ExchangeRateService exchangeRateService;

    @InjectMocks
    DefaultCurrencyConverterService currencyConverterService;

    @Test
    void 수취금액_가져오기() {
        // given
        CurrencyId currencyId = CurrencyId.KRW;
        Mockito.when(exchangeRateService.getExchangeRate(currencyId)).thenReturn(new BigDecimal("1119.93"));

        // when
        BigDecimal convertedMoney = currencyConverterService.getConvertedMoney(currencyId, new BigDecimal("100"));

        // then
        assertThat(convertedMoney).isEqualTo(new BigDecimal("111993.00"));
    }


}
