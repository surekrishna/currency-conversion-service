package com.spring.boot.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getCurrencyConversion(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		return new CurrencyConversionBean(1L,from,to,new BigDecimal(72),new BigDecimal(720),quantity,0);
	}
}
