package com.cognizant.conversion;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.conversion.model.CurrencyConversion;
import com.cognizant.conversion.model.FeignProxy;


@RestController
public class CurrencyConversionController {
	
	
	private RestTemplate restTemplate;
	
	
	private FeignProxy feignProxy;
	
	@Autowired
	public CurrencyConversionController(RestTemplate restTemplate,FeignProxy feignProxy) {
		this.restTemplate=restTemplate;
		this.feignProxy=feignProxy;
	}
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion  getCurrencyConversion(@PathVariable("from") String from, @PathVariable
            ("to") String to,@PathVariable("quantity") BigDecimal quantity) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		
		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity
		("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversion.class, uriVariables);
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		return new CurrencyConversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment()+ " " + "rest template");
		
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion  getCurrencyConversionFeign(@PathVariable("from") String from, @PathVariable
            ("to") String to,@PathVariable("quantity") BigDecimal quantity) {
		
		
		
		CurrencyConversion currencyConversion = feignProxy.retriveExchangeValue(from, to);
		
		return new CurrencyConversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment()+ " " + "rest template");
		
	}
		
	
}
