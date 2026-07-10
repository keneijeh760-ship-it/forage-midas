package com.jpmc.midascore.Service;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.foundation.Transactions;
import com.jpmc.midascore.repository.TransactionsRepository;

import com.jpmc.midascore.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionService {

    private final UserRepository userRepository;
    private final TransactionsRepository transactionsRepository;

    public TransactionService (UserRepository userRepository, TransactionsRepository transactionsRepository) {
        this.userRepository = userRepository;
        this.transactionsRepository = transactionsRepository;
    }

    public void sendTransaction(Transaction transaction) {
        UserRecord sender = userRepository.findById(transaction.getSenderId());

        if (sender == null) {
            return;
        }

        UserRecord reciepinet = userRepository.findById(transaction.getRecipientId());

        if (reciepinet == null) {
            return;
        }


        if (sender.getBalance() < transaction.getAmount()) {
            return;
        }

        sender.setBalance(sender.getBalance() - transaction.getAmount());
        reciepinet.setBalance(reciepinet.getBalance() + transaction.getAmount());

        Transactions transactions = new Transactions(sender, reciepinet, transaction.getAmount());
        userRepository.save(sender);
        userRepository.save(reciepinet);
        transactionsRepository.save(transactions);


    }


}
