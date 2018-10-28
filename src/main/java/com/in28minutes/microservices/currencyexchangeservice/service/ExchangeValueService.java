package com.in28minutes.microservices.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.in28minutes.errorhandler.NotFoundException;
import com.in28minutes.microservices.currencyexchangeservice.beans.ExchangeValueBean;
import com.in28minutes.microservices.currencyexchangeservice.beans.mappers.ExchangeValueMapper;
import com.in28minutes.microservices.currencyexchangeservice.db.entity.CurrencyExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.db.repository.ExchangeValueRepository;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service
public class ExchangeValueService {
	
	private Environment environment; 
	private ExchangeValueRepository exchangeValueRepository;
	private MapperFacade mapper;
	
	
	@Autowired
	public ExchangeValueService(final ExchangeValueRepository exchangeValueRepository, Environment environment) {
		this.exchangeValueRepository = exchangeValueRepository;
		this.environment = environment;
		
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		ExchangeValueMapper exchangeValueMapper = new ExchangeValueMapper();
		mapperFactory.classMap(CurrencyExchangeValue.class, ExchangeValueBean.class).customize(exchangeValueMapper).register();
		this.mapper = mapperFactory.getMapperFacade();
	}
	
	public ExchangeValueBean retrieveExchangeValue(String from, String to){
		
		CurrencyExchangeValue exchangeValue = exchangeValueRepository.findByCurrencyFromAndCurrencyTo(from, to)
				.orElseThrow(()->new NotFoundException("ExchangeValueBean: from " + from + " to " + to));
	
		ExchangeValueBean exchangeValueBean =  mapper.map(exchangeValue,ExchangeValueBean.class);
		exchangeValueBean.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		return exchangeValueBean;
		
	}

}
