package com.saerang.currencyconverter.domain;

public enum CurrencyId {

    KRW("한국", 2), JPY("일본", 2), PHP("필리핀", 2);

    private final String country;
    private final int scale;

    CurrencyId(String country, int scale) {
        this.country = country;
        this.scale = scale;
    }

    public String getCountry() {
        return country;
    }

    public int getScale() {
        return scale;
    }

}
