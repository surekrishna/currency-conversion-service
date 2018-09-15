package com.spring.boot.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal currencyMultiple;
	private BigDecimal totalAmount; 
	private BigDecimal quantity;
	private int port;
	
	public CurrencyConversionBean() { }

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal currencyMultiple, BigDecimal totalAmount,
			BigDecimal quantity, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyMultiple = currencyMultiple;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getCurrencyMultiple() {
		return currencyMultiple;
	}

	public void setCurrencyMultiple(BigDecimal currencyMultiple) {
		this.currencyMultiple = currencyMultiple;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
			
}
