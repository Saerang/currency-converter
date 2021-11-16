package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.app.dto.CurrencyResponse;
import com.saerang.currencyconverter.common.CurrencyConfig;
import com.saerang.currencyconverter.domain.CurrencyId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultExchangeRateService implements ExchangeRateService {

    private final RestTemplate restTemplate;

    private final CurrencyConfig currencyConfig;

    private CurrencyResponse currencyResponse;

    @Override
    public BigDecimal getExchangeRate(CurrencyId currencyId) {
        BigDecimal exchangeRate = this.getCurrencyResponse().getExchangeRate(currencyId);

        if (exchangeRate == null) {
            throw new IllegalArgumentException();
        }

        return exchangeRate.setScale(currencyId.getScale(), RoundingMode.FLOOR);
    }

    private CurrencyResponse getCurrencyResponse() {
        if (this.currencyResponse != null) {
            return this.currencyResponse;
        }

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(currencyConfig.getUrl()).queryParam("access_key", currencyConfig.getAccessKey());
        URI apiUrl = uriComponentsBuilder.build().toUri();

        ResponseEntity<CurrencyResponse> response;
        try {

            response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, CurrencyResponse.class);

            log.info(String.valueOf(response.getBody()));
        } catch (RestClientException e) {
            throw new IllegalStateException(e);
        }

        this.currencyResponse = response.getBody();

        if (!currencyResponse.isSuccess()) {
            throw new IllegalStateException();
        }

        return currencyResponse;
    }
}
