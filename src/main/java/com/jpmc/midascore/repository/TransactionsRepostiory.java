package com.jpmc.midascore.repository;

import com.jpmc.midascore.foundation.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepostiory extends CrudRepository<Transactions,Integer> {
    Transactions findById(long id);
}
