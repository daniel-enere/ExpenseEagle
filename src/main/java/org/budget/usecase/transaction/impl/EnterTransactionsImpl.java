package org.budget.usecase.transaction.impl;

import org.budget.usecase.account.GetAccounts;
import org.budget.usecase.entity.Account;
import org.budget.usecase.entity.Transaction;
import org.budget.usecase.gateway.transaction.SaveTransactionsGateway;
import org.budget.usecase.transaction.EnterTransactions;

import java.util.List;
import java.util.stream.Stream;

public class EnterTransactionsImpl implements EnterTransactions {
    private final SaveTransactionsGateway saveTransactionsGateway;
    private final GetAccounts getAccounts;

    public EnterTransactionsImpl(SaveTransactionsGateway saveTransactionsGateway, GetAccounts getAccounts){
        this.saveTransactionsGateway = saveTransactionsGateway;
        this.getAccounts = getAccounts;
    }


    @Override
    public void execute(Stream<Transaction> transactions) {
        //validate account id
        //validate category_subcategory_id
        //add to database
        List<Account> accounts = getAccounts.execute().toList();
        List<Transaction> transactionsWithAccounts = transactions.filter(transaction -> accounts.stream().anyMatch(account -> account.getId() == transaction.getAccount_id())).toList();

        Stream<Transaction> validTransactions = transactionsWithAccounts.stream();

        if(transactionsWithAccounts.stream().distinct().findAny().isEmpty()){
            throw new IllegalStateException("no account found");
        }
        saveTransactionsGateway.execute(validTransactions);
    }

    private boolean isAccountValid(String accountId){
        //
        return false;
    }
}
