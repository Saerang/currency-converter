package com.saerang.currencyconverter.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CurrencyIdTest {

    @Test
    void KRW_존재여부_확인() {
        // given
        // when
        CurrencyId krw = CurrencyId.valueOf("KRW");

        // then
        assertThat(krw).isEqualTo(CurrencyId.KRW);
    }

    @Test
    void EUR_존재여부_확인() {
        // given
        // when
        // then
        assertThatThrownBy(() -> CurrencyId.valueOf("EUR")).isInstanceOf(IllegalArgumentException.class);
    }


}
