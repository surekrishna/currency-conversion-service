package com.spring.boot.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.spring.boot.microservices.currencyconversionservice.service.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy openFeignproxy;

	/*
	 * The getCurrencyConversion() is used for converting from {from} currency rate to {to} currency and calculate totalAmount 
	 * for the given quantity
	 */
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getCurrencyConversion(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		Map<String,String> pVariables = new HashMap<>();
		pVariables.put("from", from);
		pVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> forEntity = new RestTemplate().
				getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, pVariables);
		
		CurrencyConversionBean respone = forEntity.getBody();
		
		return new CurrencyConversionBean(respone.getId(),from,to,respone.getConversionMultiple(),respone.getConversionMultiple().multiply(quantity),quantity,respone.getPort());
	}
	
	/*
	 * The getCurrencyConversionFeign() is exactly same as getCurrencyConversion() used openfeign to 
	 * RestTemplate client to reduce code  
	 */
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getCurrencyConversionFeign(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
						
		CurrencyConversionBean respone = openFeignproxy.getCurrencyExchangeValue(from, to);
		
		return new CurrencyConversionBean(respone.getId(),from,to,respone.getConversionMultiple(),respone.getConversionMultiple().multiply(quantity),quantity,respone.getPort());
	}
}
