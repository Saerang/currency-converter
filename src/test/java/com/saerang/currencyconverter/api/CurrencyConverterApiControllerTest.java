package com.saerang.currencyconverter.api;

import com.saerang.currencyconverter.app.ExchangeRateService;
import com.saerang.currencyconverter.domain.CurrencyId;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyConverterApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExchangeRateService exchangeRateService;

    // TODO: mockito 사용하면 좋음.
    @Test
    void 수취금액_가져오기() throws Exception {
        // given
        CurrencyId currencyId = CurrencyId.KRW;
        given(exchangeRateService.getExchangeRate(currencyId)).willReturn(new BigDecimal("1000"));

        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/currencies/{currencyId}/conversion", currencyId).contentType(MediaType.APPLICATION_JSON)
                .param("money", "100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("100,000.00"));
    }

    @Test
    void 허용되지_않는_커런시요청() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/currencies/{currencyId}/conversion", "AAA").contentType(MediaType.APPLICATION_JSON)
                .param("money", "100"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
