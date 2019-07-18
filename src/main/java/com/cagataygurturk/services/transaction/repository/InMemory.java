package com.cagataygurturk.services.transaction.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cagataygurturk.models.Transaction;
import com.cagataygurturk.storage.Storage;

@Component("transaction_repository_inmemory")
public class InMemory extends TransactionRepository {

    protected Storage<Transaction> storage;

    @Autowired
    public InMemory(@Qualifier("storage_inmemory") Storage<Transaction> storage) {
        this.storage = storage;
    }

}
