package com.in28minutes.microservices.currencyexchangeservice.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.microservices.currencyexchangeservice.db.entity.CurrencyExchangeValue;


@Repository
public interface ExchangeValueRepository extends JpaRepository<CurrencyExchangeValue, Integer> {

	Optional<CurrencyExchangeValue> findByCurrencyFromAndCurrencyTo(String currencyFrom , String currencyTo);
}
