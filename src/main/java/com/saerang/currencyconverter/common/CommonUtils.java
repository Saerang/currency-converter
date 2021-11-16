package com.saerang.currencyconverter.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CommonUtils {

    public static String getResponseDecimalFormat(BigDecimal money) {
        DecimalFormat df = new DecimalFormat("#,###.00");

        return df.format(money);
    }

}
