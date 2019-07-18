package com.cagataygurturk.services.transaction.repository;

abstract public class TransactionRepository {

    /**
     * Data Access Objects should be chainable.
     * It allows to attach easily another Data Access Layer in front of another one
     */
    protected TransactionRepository fallbackRepository;

    public void setFallbackRepository(TransactionRepository fallbackRepository) {
        this.fallbackRepository = fallbackRepository;
    }
}
