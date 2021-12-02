package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.common.exception.CurrencyNotFoundException;
import com.saerang.currencyconverter.domain.Currency;
import com.saerang.currencyconverter.domain.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultCurrencyService implements CurrencyService{

    private final CurrencyRepository currencyRepository;

    @Override
    public BigDecimal exchange(String currencyId, BigDecimal amount) {
        Currency currency = currencyRepository.findByCurrencyId(currencyId)
                .orElseThrow(CurrencyNotFoundException::new);

        return currency.getExchange(amount);
    }

    @Override
    public BigDecimal getExchangeRate(String currencyId) {
        Currency currency = currencyRepository.findByCurrencyId(currencyId)
                .orElseThrow(CurrencyNotFoundException::new);

        return currency.getExchangeRate();
    }

    @Override
    public Currency getCurrency(String currencyId) {
        return currencyRepository.findByCurrencyId(currencyId)
                .orElseThrow(CurrencyNotFoundException::new);
    }
}
