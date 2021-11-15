package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.domain.Currency;
import com.saerang.currencyconverter.domain.CurrencyId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DefaultCurrencyConverterService implements CurrencyConverterService {

    final private ExchangeRateService exchangeRateService;

    @Override
    public BigDecimal getConvertedMoney(CurrencyId currencyId, BigDecimal money) {
        Currency currency = new Currency(currencyId, this.exchangeRateService.getExchangeRate(currencyId));

        return currency.getExchangedMoney(money);
    }

}
