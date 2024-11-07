package com.example.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.entity.Transaction;
import com.example.wallet.exception.NoBalanceException;
import com.example.wallet.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/do_transaction/{id}/{amount}")
	public Transaction doTransaction(@PathVariable("id") Integer id,@PathVariable("amount") Double amount) throws NoBalanceException {
		return transactionService.createTransaction(id, amount);
	}
}
