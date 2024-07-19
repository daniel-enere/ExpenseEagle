package org.budget.gateway.transaction;

import org.budget.gateway.data.entity.TransactionEntity;
import org.budget.gateway.data.repository.TransactionRepository;
import org.budget.usecase.entity.Transaction;
import org.budget.usecase.gateway.transaction.SaveTransactionsGateway;

import java.util.function.Function;
import java.util.stream.Stream;

public class SaveTransactionsGatewayImpl implements SaveTransactionsGateway {
    private final TransactionRepository transactionRepository;
    private final Function<Transaction, TransactionEntity> transactionToTransactionEntityMapper;

    public SaveTransactionsGatewayImpl(TransactionRepository transactionRepository, Function<Transaction, TransactionEntity> transactionToTransactionEntityMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionToTransactionEntityMapper = transactionToTransactionEntityMapper;
    }

    @Override
    public void execute(Stream<Transaction> transactions) {
        transactions.map(transactionToTransactionEntityMapper).forEach(transactionRepository::save);
    }
}
