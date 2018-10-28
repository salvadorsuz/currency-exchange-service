package com.in28minutes.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.beans.ExchangeValueBean;
import com.in28minutes.microservices.currencyexchangeservice.service.ExchangeValueService;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	
	private ExchangeValueService exchangeValueService;
	
	@Autowired
	public CurrencyExchangeController(final ExchangeValueService exchangeValueService) {
		super();
		this.exchangeValueService = exchangeValueService;
	}


	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValueBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
		return exchangeValueService.retrieveExchangeValue(from, to);
	}

}
