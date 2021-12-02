package com.saerang.currencyconverter.common;

import com.saerang.currencyconverter.app.enumerate.CurrencyInfo;
import com.saerang.currencyconverter.domain.Currency;
import com.saerang.currencyconverter.domain.repository.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@Transactional
public class BaseTest {

    @Autowired
    CurrencyRepository currencyRepository;

    @BeforeEach
    public void setUp() {
        CurrencyInfo krw = CurrencyInfo.KRW;
        CurrencyInfo jpy = CurrencyInfo.JPY;
        new Currency(krw.getName(), 2, new BigDecimal("1000"));
        currencyRepository.saveAll(
                List.of(
                        new Currency(krw.getName(), krw.getScale(), new BigDecimal("1000")),
                        new Currency(jpy.getName(), jpy.getScale(), new BigDecimal("100"))
                )
        );
    }

}
