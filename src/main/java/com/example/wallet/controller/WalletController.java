package com.example.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.entity.Wallet;
import com.example.wallet.service.WalletService;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
	@Autowired
	private WalletService walletService;

	@GetMapping
	public List<Wallet> getAllWallets() {
		return walletService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Wallet> getWalletById(@PathVariable("id") Integer id) {
		Wallet wallet = walletService.findById(id);
		return wallet != null ? ResponseEntity.ok(wallet) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public Wallet createWallet(@RequestBody Wallet wallet) {
		return walletService.save(wallet);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Wallet> updateWallet(@PathVariable("id") Integer id, @RequestBody Wallet wallet) {
		Wallet updatedWallet = walletService.update(id, wallet);
		return ResponseEntity.ok(updatedWallet);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWallet(@PathVariable("id") Integer id) {
		walletService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
