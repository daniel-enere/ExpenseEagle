package org.budget.configuration.gateway;

import org.budget.gateway.account.GetAccountGatewayImpl;
import org.budget.gateway.account.GetAccountsGatewayImpl;
import org.budget.gateway.account.SaveAccountGatewayImpl;
import org.budget.gateway.data.entity.AccountEntity;
import org.budget.gateway.data.entity.TransactionEntity;
import org.budget.gateway.data.repository.AccountRepository;
import org.budget.gateway.data.repository.TransactionRepository;
import org.budget.gateway.mapper.AccountToAccountEntityMapper;
import org.budget.gateway.mapper.TransactionToTransactionEntity;
import org.budget.gateway.transaction.SaveTransactionsGatewayImpl;
import org.budget.usecase.entity.Account;
import org.budget.usecase.entity.Transaction;
import org.budget.usecase.gateway.account.GetAccountGateway;
import org.budget.usecase.gateway.account.GetAccountsGateway;
import org.budget.usecase.gateway.account.SaveAccountGateway;
import org.budget.usecase.gateway.transaction.SaveTransactionsGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayConfiguration {
    @Bean
    public Function<Account, AccountEntity> accountToAccountEntityMapper() {
        return new AccountToAccountEntityMapper();
    }

    @Bean
    public SaveAccountGateway saveAccountGateway(AccountRepository accountRepository){
        return new SaveAccountGatewayImpl(accountRepository);
    }

    @Bean
    public GetAccountsGateway getAccountsGateway(AccountRepository accountRepository){
        return new GetAccountsGatewayImpl(accountRepository);
    }

    @Bean
    public GetAccountGateway getAccountGateway(AccountRepository accountRepository){
        return new GetAccountGatewayImpl(accountRepository);
    }

    @Bean
    public SaveTransactionsGateway saveTransactionsGateway(TransactionRepository transactionRepository, Function<Transaction, TransactionEntity> transactionToTransactionEntityMapper){
        return new SaveTransactionsGatewayImpl(transactionRepository, transactionToTransactionEntityMapper);
    }

    @Bean
    public Function<Transaction, TransactionEntity> transactionToTransactionEntityMapper(GetAccountGateway getAccountsGateway){
        return new TransactionToTransactionEntity(getAccountsGateway);
    }
}
