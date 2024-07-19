package org.budget.configuration.usecase;

import org.budget.gateway.data.entity.AccountEntity;
import org.budget.usecase.account.CreateAccount;
import org.budget.usecase.account.GetAccounts;
import org.budget.usecase.entity.Account;
import org.budget.usecase.gateway.account.GetAccountsGateway;
import org.budget.usecase.gateway.account.SaveAccountGateway;
import org.budget.usecase.account.impl.CreateAccountImpl;
import org.budget.usecase.account.impl.GetAccountsImpl;
import org.budget.usecase.gateway.transaction.SaveTransactionsGateway;
import org.budget.usecase.transaction.EnterTransactions;
import org.budget.usecase.transaction.impl.EnterTransactionsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateAccount createAccount(SaveAccountGateway saveAccountGateway, Function<Account, AccountEntity> accountToAccountEntityMapper){
        return new CreateAccountImpl(saveAccountGateway, accountToAccountEntityMapper);
    }

    @Bean
    public GetAccounts getAccounts(GetAccountsGateway getAccountsGateway){
        return new GetAccountsImpl(getAccountsGateway);
    }

    @Bean
    public EnterTransactions enterTransactions(GetAccounts getAccounts, SaveTransactionsGateway saveTransactionsGateway){
        return new EnterTransactionsImpl(saveTransactionsGateway, getAccounts);
    }
}
