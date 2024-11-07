package com.example.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wallet.constant.Constants;
import com.example.wallet.entity.Transaction;
import com.example.wallet.entity.Wallet;
import com.example.wallet.exception.NoBalanceException;
import com.example.wallet.repository.TransactionRepository;
import com.example.wallet.repository.WalletRepository;

@Service
public class TransactionService {

    @Autowired
    private WalletRepository walletRepository;
    
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Integer userWalletId, Double amount) throws NoBalanceException {
        Wallet wallet = walletRepository.findById(userWalletId)
                .orElseThrow(() -> new NoBalanceException(Constants.USER_NOT_FOUND));

        if (wallet.getBalance() < amount) {
            throw new NoBalanceException(Constants.INSUFFICIENT_BALANCE);
        }

        wallet.setBalance(wallet.getBalance() - amount);
        walletRepository.save(wallet);

        Transaction transaction = new Transaction(userWalletId,amount, wallet, java.time.LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}

