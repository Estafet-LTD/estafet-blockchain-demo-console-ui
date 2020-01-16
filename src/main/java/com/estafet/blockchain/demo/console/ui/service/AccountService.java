package com.estafet.blockchain.demo.console.ui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.blockchain.demo.console.ui.model.Account;
import com.estafet.microservices.scrum.lib.commons.rest.RestHelper;

@Service
public class AccountService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Account> getAccounts() {
		return RestHelper.getRestQuery(restTemplate,
				System.getenv("BANK_MS_SERVICE_URI") + "/accounts", Account.class);
	}

	public Account getAccount(int id) {
		return restTemplate.getForObject(System.getenv("BANK_MS_SERVICE_URI") + "/account/{id}", Account.class, id);
	}

}