package com.saerang.currencyconverter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;

public class DecimalFormatTest {

    @Test
    void testDecimalFormat() {
        // given
        DecimalFormat df = new DecimalFormat("#,###.00");
        
        // when
        BigDecimal bigDecimal2 = new BigDecimal("123456.78");
        BigDecimal bigDecimal3 = new BigDecimal("123456.7");
        BigDecimal bigDecimal4 = new BigDecimal("123456");
        BigDecimal bigDecimal5 = new BigDecimal("123456789");

        // then
        assertThat(df.format(bigDecimal2)).isEqualTo("123,456.78");
        assertThat(df.format(bigDecimal3)).isEqualTo("123,456.70");
        assertThat(df.format(bigDecimal4)).isEqualTo("123,456.00");
        assertThat(df.format(bigDecimal5)).isEqualTo("123,456,789.00");
    }

}
