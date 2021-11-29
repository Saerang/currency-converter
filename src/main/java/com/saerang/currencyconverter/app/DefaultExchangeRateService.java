package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.domain.CurrencyId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultExchangeRateService implements ExchangeRateService {

    private final ExternalCurrency externalCurrency;

    @Override
    public BigDecimal getExchangeRate(CurrencyId currencyId) {
        BigDecimal exchangeRate = externalCurrency.getCurrencyResponse().getExchangeRate(currencyId);

        if (exchangeRate == null) {
            throw new IllegalArgumentException();
        }

        return exchangeRate.setScale(currencyId.getScale(), RoundingMode.FLOOR);
    }


}
