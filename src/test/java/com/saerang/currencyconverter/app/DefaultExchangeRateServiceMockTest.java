package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.app.dto.CurrencyResponse;
import com.saerang.currencyconverter.common.CurrencyConfig;
import com.saerang.currencyconverter.domain.CurrencyId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DefaultExchangeRateServiceMockTest {

    @Mock
    RestTemplate restTemplate;

    @Mock
    CurrencyConfig currencyConfig;

    @InjectMocks
    DefaultExchangeRateService exchangeRateService;

    @Test
    void KRW_환율_가져오기() {
        // given
        Mockito.when(currencyConfig.getUrl()).thenReturn("http://api.currencylayer.com/live");
        Mockito.when(currencyConfig.getAccessKey()).thenReturn("accessKey");

        Map<String, BigDecimal> quotes = new HashMap<>();
        BigDecimal krw = new BigDecimal("1179.089912");
        quotes.put("USDKRW", krw);

        CurrencyResponse currencyResponse = new CurrencyResponse(true, null, "USD", quotes);
        Mockito.when(
                restTemplate.exchange(
                        ArgumentMatchers.any(URI.class),
                        ArgumentMatchers.any(HttpMethod.class),
                        ArgumentMatchers.any(),
                        ArgumentMatchers.<Class<CurrencyResponse>>any())
        ).thenReturn(new ResponseEntity<>(currencyResponse, HttpStatus.OK));

        // when
        BigDecimal exchangeRate = exchangeRateService.getExchangeRate(CurrencyId.KRW);

        // then
        assertThat(exchangeRate).isEqualTo(krw);
    }

}
