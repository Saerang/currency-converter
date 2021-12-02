package com.saerang.currencyconverter.app;

import com.saerang.currencyconverter.app.dto.CurrencyResponseDto;
import com.saerang.currencyconverter.app.enumerate.CurrencyInfo;
import com.saerang.currencyconverter.common.CurrencyConfig;
import com.saerang.currencyconverter.common.exception.InternalServerErrorException;
import com.saerang.currencyconverter.domain.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExternalCurrency {

    private final RestTemplate restTemplate;

    private final CurrencyConfig currencyConfig;

    private final CurrencyRepository currencyRepository;

    /** TODO: 나중에 배치로 만들어서 업데이트 부분만 할 듯. UTC 0으로 배치 변경.
     ** TODO: 테스트코드 Currency 를 KRW 안쓰면 풀어도 됨.
    */
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
