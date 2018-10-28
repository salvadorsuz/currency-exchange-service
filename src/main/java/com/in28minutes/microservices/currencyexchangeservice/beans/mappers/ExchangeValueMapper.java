package com.in28minutes.microservices.currencyexchangeservice.beans.mappers;

import org.springframework.stereotype.Component;

import com.in28minutes.microservices.currencyexchangeservice.beans.ExchangeValueBean;
import com.in28minutes.microservices.currencyexchangeservice.db.entity.CurrencyExchangeValue;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class ExchangeValueMapper extends CustomMapper<CurrencyExchangeValue, ExchangeValueBean> {
	
	@Override
	public void mapAtoB(CurrencyExchangeValue a, ExchangeValueBean b, MappingContext context) {
		b.setFrom(a.getCurrencyFrom());
		b.setTo(a.getCurrencyTo());
		b.setConversionMultiple(a.getConversionMultiple());
	}
	
	@Override
	public void mapBtoA(ExchangeValueBean b, CurrencyExchangeValue a, MappingContext context){
		a.setCurrencyFrom(b.getFrom());
		a.setCurrencyTo(b.getTo());
		a.setConversionMultiple(b.getConversionMultiple());
	}
}
