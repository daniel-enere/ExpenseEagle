package org.budget.gateway.mapper;

import org.budget.gateway.data.entity.AccountEntity;
import org.budget.gateway.data.entity.TransactionEntity;
import org.budget.usecase.entity.Transaction;
import org.budget.usecase.gateway.account.GetAccountGateway;

import java.util.Optional;
import java.util.function.Function;

public class TransactionToTransactionEntity implements Function<Transaction, TransactionEntity> {
    private final GetAccountGateway getAccountGateway;
    public TransactionToTransactionEntity(GetAccountGateway getAccountGateway){
        this.getAccountGateway = getAccountGateway;
    }
    @Override
    public TransactionEntity apply(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        Optional<AccountEntity> accountEntity = getAccountGateway.execute(transaction.getAccount_id());
        transactionEntity.setAmount(transaction.getAmount());

        System.err.println("category id: " + transaction.getCategory_id());

        transactionEntity.setCategory_id(transaction.getCategory_id()); //TODO first thing to fix
        System.err.println("trx date: " + transaction.getTrxDate());
        transactionEntity.setTrxDate(transaction.getTrxDate());
        System.err.println("trx entry date: " + transaction.getTrxEntryDate());
        transactionEntity.setTrxEntryDate(transaction.getTrxEntryDate());
        transactionEntity.setAccount(accountEntity.orElseThrow());

        //TODO fix later
        return transactionEntity;
    }
}
