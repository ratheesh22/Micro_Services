package com.cognizant.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exchange.model.CurrencyExchange;
import com.cognizant.exchange.repo.CurrencyExchangeRepo;

@Service
public class CurrencyService {
	
	@Autowired
	private CurrencyExchangeRepo exchangeRepo;

	
	public void saveCurrency(CurrencyExchange exchange) {
		exchangeRepo.save(exchange);
		
	}


	public CurrencyExchange findByFromAndTo(String from, String to) {
		// TODO Auto-generated method stub
		return exchangeRepo.findByFromAndTo(from, to);
	}
}
