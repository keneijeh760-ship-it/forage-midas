package com.jpmc.midascore.repository;

import com.jpmc.midascore.foundation.Transactions;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionsRepostiory extends CrudRepository<Transactions,Integer> {
    Optional<Transactions> findById(long id);
}
