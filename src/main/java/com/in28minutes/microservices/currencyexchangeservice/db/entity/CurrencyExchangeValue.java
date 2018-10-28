package com.in28minutes.microservices.currencyexchangeservice.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_EXCHANGE_VALUE")
public class CurrencyExchangeValue implements Serializable{
	
	private static final long serialVersionUID = 4097582537510061454L;

	@Id
	@GeneratedValue(generator = "EXCHANGE_VALUE_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "EXCHANGE_VALUE_SEQ", sequenceName = "EXCHANGE_VALUE_SEQ", allocationSize=1)
	@Column(name="ID_EXCHANGE_VALUE")
	private Integer idExchangeValue;
	
	@Column(name="CURRENCY_FROM")
	private String currencyFrom;
	
	@Column(name="CURRENCY_TO")
	private String currencyTo;
	
	@Column(name="CONVERSION_MULTIPLE")
	private Double conversionMultiple;

	
	public CurrencyExchangeValue() {
		super();
	}
	
	public CurrencyExchangeValue(Integer idExchangeValue, String currencyFrom, String currencyTo,
			Double conversionMultiple) {
		super();
		this.idExchangeValue = idExchangeValue;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.conversionMultiple = conversionMultiple;
	}

	public Integer getIdExchangeValue() {
		return idExchangeValue;
	}

	public void setIdExchangeValue(Integer idExchangeValue) {
		this.idExchangeValue = idExchangeValue;
	}

	public Double getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(Double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	
	@Override
	public String toString() {
		return "ExchangeValue [idExchangeValue=" + idExchangeValue + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", conversionMultiple=" + conversionMultiple + "]";
	}

	
}
