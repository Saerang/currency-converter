package com.saerang.currencyconverter.api;

import com.saerang.currencyconverter.common.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.isNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
class CurrencyApiControllerTest extends BaseTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void 환전금액_가져오기() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/currencies/{currencyId}/exchange", "KRW").contentType(APPLICATION_JSON)
                .param("amount", "100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void 환전금액_가져오기_정확한_값_체크() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/currencies/{currencyId}/exchange", "AAA").contentType(APPLICATION_JSON)
                .param("amount", "100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("100,000.00"));
    }

    @Test
    void 환전금액_가져오기_없는_통화() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/currencies/{currencyId}/exchange", "ZZZ").contentType(APPLICATION_JSON)
                .param("amount", "100"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void 환율가져오기() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/currencies/{currencyId}/exchangeRate", "KRW").contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void 환율가져오기_정확한_값_체크() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/currencies/{currencyId}/exchangeRate", "AAA").contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1,000.00"));;
    }

    @Test
    void 환율가져오기_없는_통화() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(get("/api/currencies/{currencyId}/exchangeRate", "ZZZ").contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
