package com.saerang.currencyconverter.app.enumerate;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CurrencyInfo {

    KRW("한국", 2, "KRW"), JPY("일본", 0, "JPY"), PHP("필리핀", 2, "PHP");

    private final String country;
    private final int scale;
    private final String name;

    CurrencyInfo(String country, int scale, String name) {
        this.country = country;
        this.scale = scale;
        this.name = name;
    }

    public static boolean isCurrencyId(String currencyId) {
        try {
            valueOf(currencyId);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    public static String getJoinCurrencyInfo() {
        return Arrays.stream(CurrencyInfo.values()).map(CurrencyInfo::getName).collect(Collectors.joining(","));
    }

    public String getCountry() {
        return country;
    }

    public int getScale() {
        return scale;
    }

    public String getName() {
        return name;
    }

}
