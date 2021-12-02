package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.app.dto.CurrencyResponseDto;
import com.saerang.currencyconverter.app.enumerate.CurrencyInfo;
import com.saerang.currencyconverter.common.CurrencyConfig;
import com.saerang.currencyconverter.common.exception.InternalServerErrorException;
import com.saerang.currencyconverter.domain.Currency;
import com.saerang.currencyconverter.domain.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExternalCurrency {

    private final RestTemplate restTemplate;

    private final CurrencyConfig currencyConfig;

    private final CurrencyRepository currencyRepository;

    //TODO: 나중에 배치로 만들어서 UTC 0으로 배치 변경, 테스트 코드 만들때 불편함.
//    @PostConstruct
    public void getCurrencyResponse() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl(currencyConfig.getUrl())
                .queryParam("access_key", currencyConfig.getAccessKey())
                .queryParam("currencies", CurrencyInfo.getJoinCurrencyInfo());
        URI apiUrl = uriComponentsBuilder.build().toUri();

        ResponseEntity<CurrencyResponseDto> response;
        try {
            response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, CurrencyResponseDto.class);

            log.info(String.valueOf(response.getBody()));
        } catch (RestClientException e) {
            throw new InternalServerErrorException(e);
        }

        if (!response.getBody().isSuccess()) {
            throw new InternalServerErrorException();
        }

        currencyRepository.saveAll(response.getBody().toEntities());
    }
}
