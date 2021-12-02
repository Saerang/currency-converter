package com.saerang.currencyconverter.domain.repository;

import com.saerang.currencyconverter.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findByCurrencyId(String currencyId);
}
