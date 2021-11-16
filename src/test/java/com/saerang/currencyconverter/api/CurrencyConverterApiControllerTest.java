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
class CurrencyConverterApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    // TODO: mockito 사용하면 좋음.
    @Test
//    @Disabled("연속 호출 시 실패 - Mock Test Code 만들자")
    void 수취금액_가져오기() throws Exception {
        // given
        // when
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/currencies/{currencyId}/conversion", "KRW").contentType(MediaType.APPLICATION_JSON)
                .param("money", "100"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
//    @Disabled("연속 호출 시 실패 - Mock Test Code 로 만들자")
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
