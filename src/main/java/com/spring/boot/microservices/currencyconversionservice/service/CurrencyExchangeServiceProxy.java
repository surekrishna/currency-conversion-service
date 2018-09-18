package com.spring.boot.microservices.currencyconversionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.boot.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
	
	/*
	 * This method(every thing is same) is taken from currency-exchange application to call the rest service using
	 * openfeign to reduce code and maintainance  
	 */
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getCurrencyExchangeValue(@PathVariable String from, @PathVariable String to);

}
