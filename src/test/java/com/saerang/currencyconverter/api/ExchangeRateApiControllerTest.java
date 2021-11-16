package com.saerang.currencyconverter.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExchangeRateApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void KRW_환율가져오기() throws Exception {
        // given
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
