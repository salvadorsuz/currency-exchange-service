package com.in28minutes.microservices.currencyexchangeservice.beans;

import java.io.Serializable;

public class ExchangeValueBean implements Serializable {
	
	private static final long serialVersionUID = 1120799235742497183L;
	
	private String from;
	private String to;
	private Double conversionMultiple;
	private int port;
	
	public ExchangeValueBean() {
		super();
	}
	
	public ExchangeValueBean(String from, String to, Double conversionMultiple) {
		super();
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	public Double getConversionMultiple() {
		return conversionMultiple;
	}
	
	public void setConversionMultiple(Double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
