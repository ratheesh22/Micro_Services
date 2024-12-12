package com.cognizant.exchange.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exchange.service.*;
import com.cognizant.exchange.model.CurrencyExchange;
import com.cognizant.exchange.repo.CurrencyExchangeRepo;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;
    

    @Autowired
    private CurrencyService repo;
    
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(@PathVariable("from") String from, @PathVariable
            ("to") String to){

logger.info("retrieveExchangeValue called with {} to {}", from, to);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		
		if(currencyExchange ==null) {
			return null;
		}
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;

    }
}

