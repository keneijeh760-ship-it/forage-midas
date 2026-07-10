package com.jpmc.midascore.Service;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.foundation.Transactions;
import com.jpmc.midascore.repository.TransactionsRepostiory;
import com.jpmc.midascore.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final UserRepository userRepository;
    private final TransactionsRepostiory  transactionsRepostiory;

    public TransactionService (UserRepository userRepository, TransactionsRepostiory  transactionsRepostiory) {
        this.userRepository = userRepository;
        this.transactionsRepostiory = transactionsRepostiory;
    }

    public void sendTransaction(Transaction transaction) {
        UserRecord sender = userRepository.findById(transaction.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        UserRecord reciepinet = userRepository.findById(transaction.getRecipientId())
                .orElseThrow(() -> new RuntimeException("Recipient not found"));

        if (sender.getBalance() < transaction.getAmount()) {
            throw new RuntimeException();
        }

        sender.setBalance(sender.getBalance() - transaction.getAmount());
        reciepinet.setBalance(reciepinet.getBalance() + transaction.getAmount());

        Transactions transactions = new Transactions(sender, reciepinet, transaction.getAmount());
        userRepository.save(sender);
        userRepository.save(reciepinet);
        transactionsRepostiory.save(transactions);


    }


}
