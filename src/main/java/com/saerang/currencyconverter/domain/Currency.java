package com.saerang.currencyconverter.domain;

import com.saerang.currencyconverter.common.BaseTimeEntity;
import com.saerang.currencyconverter.common.validation.CurrencyId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Currency extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CurrencyId
    @NotNull(message = "currencyId may not be null.")
    @Column(name="currencyUnique" , unique=true)
    private String currencyId;

    private int scale;

    private BigDecimal exchangeRate;

    public Currency(String currencyId, int scale, BigDecimal exchangeRate) {
        this.currencyId = currencyId;
        this.scale = scale;
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchange(BigDecimal amount) {
        return amount.multiply(this.exchangeRate).setScale(this.scale, RoundingMode.FLOOR);
    }

}
