package com.saerang.currencyconverter.api;

import com.saerang.currencyconverter.app.ExchangeRateService;
import com.saerang.currencyconverter.app.ExternalCurrency;
import com.saerang.currencyconverter.app.dto.CurrencyResponse;
import com.saerang.currencyconverter.domain.CurrencyId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExchangeRateApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExternalCurrency externalCurrency;

    @Test
    void KRW_환율가져오기() throws Exception {
        // given
        Map<String, BigDecimal> quotes = Map.ofEntries(
                Map.entry("USDKRW", new BigDecimal("1000.000000")),
                Map.entry("USDJPY", new BigDecimal("113.441495"))
        );

        CurrencyResponse currencyResponse = new CurrencyResponse(true, "https://currencylayer.com/terms", "USD", quotes);
        given(externalCurrency.getCurrencyResponse()).willReturn(currencyResponse);

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/currencies/{currencyId}/exchangeRate", "KRW").contentType(MediaType.APPLICATION_JSON)
                .param("money", "100"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void AAA_환율가져오기() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/currencies/{currencyId}/exchangeRate", "AAA").contentType(MediaType.APPLICATION_JSON)
                .param("money", "100"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
