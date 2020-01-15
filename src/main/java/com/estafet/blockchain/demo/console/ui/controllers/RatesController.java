package com.estafet.blockchain.demo.console.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estafet.blockchain.demo.console.ui.service.ExchangeRateService;

@Controller
public class RatesController {

	@Autowired
	ExchangeRateService exchangeRateService;
	
	@RequestMapping("/rates")
	public String projects(Model model) {
		model.addAttribute("rates", exchangeRateService.getExchangeRates());
		return "rates";
	}

}
