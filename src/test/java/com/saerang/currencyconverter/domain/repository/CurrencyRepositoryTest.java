package com.saerang.currencyconverter.domain.repository;

import com.saerang.currencyconverter.domain.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CurrencyRepositoryTest {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    TestEntityManager em;

    @Test
    void 기본테스트() {
        // given
        Currency currency = new Currency("KRW", 2, new BigDecimal("1000"));

        // when
        Currency savedCurrency = currencyRepository.save(currency);

        em.flush();
        em.clear();

        Currency findCurrency = currencyRepository.findById(savedCurrency.getId()).orElseThrow();

        // then
        assertThat(savedCurrency.getId()).isEqualTo(findCurrency.getId());
    }

}
