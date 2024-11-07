package com.example.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wallet.entity.Wallet;
import com.example.wallet.repository.WalletRepository;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public Wallet findById(Integer id) {
        return walletRepository.findById(id).orElse(null);
    }

    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Wallet update(Integer id, Wallet wallet) {
        wallet.setId(id);
        return walletRepository.save(wallet);
    }

    public void delete(Integer id) {
        walletRepository.deleteById(id);
    }
}
