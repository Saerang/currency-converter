package com.saerang.currencyconverter.app;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultExchangeRateServiceMockTest {

    /*@Mock
    ExternalCurrency externalCurrency;

    @InjectMocks
    ExchangeRateService exchangeRateService;

    @Test
    @Disabled("restTemplate 테스트 코드 아까워서 내비둠.")
    void test() {
        // given
//        Mockito.when(currencyConfig.getUrl()).thenReturn("http://api.currencylayer.com/live");
//        Mockito.when(currencyConfig.getAccessKey()).thenReturn("accessKey");
//
//        Map<String, BigDecimal> quotes = new HashMap<>();
//        BigDecimal krw = new BigDecimal("1179.089912");
//        quotes.put("USDKRW", krw);
//
//        CurrencyResponse currencyResponse = new CurrencyResponse(true, null, "USD", quotes);
//        Mockito.when(
//                restTemplate.exchange(
//                        ArgumentMatchers.any(URI.class),
//                        ArgumentMatchers.any(HttpMethod.class),
//                        ArgumentMatchers.any(),
//                        ArgumentMatchers.<Class<CurrencyResponse>>any())
//        ).thenReturn(new ResponseEntity<>(currencyResponse, HttpStatus.OK));

        // when
//        BigDecimal exchangeRate = exchangeRateService.getExchangeRate(CurrencyId.KRW);

        // then
//        assertThat(exchangeRate).isEqualTo(new BigDecimal("1179.08"));
    }

    @Test
    void KRW_환율_가져오기() {
        // given
        Map<String, BigDecimal> quotes = new HashMap<>();
        BigDecimal krw = new BigDecimal("1179.089912");
        quotes.put("USDKRW", krw);

        CurrencyResponseDto currencyResponseDTO = new CurrencyResponseDto(true, null, "USD", quotes);

//        Mockito.when(externalCurrency.getCurrencyResponse()).thenReturn(currencyResponseDTO);

        // when
//        BigDecimal exchangeRate = exchangeRateService.getExchangeRate(CurrencyId.KRW);

        // then
//        assertThat(exchangeRate).isEqualTo(new BigDecimal("1179.08"));
    }*/

}
