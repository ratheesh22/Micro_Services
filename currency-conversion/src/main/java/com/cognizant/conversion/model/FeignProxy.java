package com.cognizant.conversion.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(url = "localhost:8000",name = "currency-exchange")
@FeignClient(name = "currency-exchange")
public interface FeignProxy {
	
	 @GetMapping("/currency-exchange/from/{from}/to/{to}")
	    public CurrencyConversion retriveExchangeValue(@PathVariable("from") String from, @PathVariable
	            ("to") String to);
}
