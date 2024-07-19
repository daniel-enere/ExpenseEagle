package org.budget.configuration.controller;

import org.budget.controller.web.account.action.CreateAccountAction;
import org.budget.controller.web.account.action.GetAccountAction;
import org.budget.controller.web.account.action.GetAccountsAction;
import org.budget.controller.web.account.action.impl.CreateAccountActionImpl;
import org.budget.controller.web.account.action.impl.GetAccountActionImpl;
import org.budget.controller.web.account.action.impl.GetAccountsActionImpl;
import org.budget.controller.web.account.dto.AccountDto;
import org.budget.controller.web.account.mapper.AccountDtoToAccountMapper;
import org.budget.controller.web.transaction.action.EnterTransactionAction;
import org.budget.controller.web.transaction.action.impl.EnterTransactionActionImpl;
import org.budget.controller.web.transaction.dto.TransactionDto;
import org.budget.controller.web.transaction.mapper.TransactionDtoToTransactionMapper;
import org.budget.usecase.account.CreateAccount;
import org.budget.usecase.account.GetAccounts;
import org.budget.usecase.entity.Account;
import org.budget.usecase.entity.Transaction;
import org.budget.usecase.transaction.EnterTransactions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ControllerConfiguration {
    //Account
    @Bean
    public CreateAccountAction createAccountAction(CreateAccount createAccount, Function<AccountDto, Account> accountDtoToAccountMapper){
        return new CreateAccountActionImpl(createAccount, accountDtoToAccountMapper);
    }

    @Bean
    public GetAccountAction getAccountAction(){
        return new GetAccountActionImpl();
    }

    @Bean
    GetAccountsAction getAccountsAction(GetAccounts getAccounts) {
        return new GetAccountsActionImpl(getAccounts);
    }

    @Bean
    public Function<AccountDto, Account> accountDtoToAccountMapper() {
        return new AccountDtoToAccountMapper();
    }


    //Transaction
    @Bean
    public Function<TransactionDto, Transaction> transactionDtoToTransactionMapper(){
        return new TransactionDtoToTransactionMapper();
    }
    @Bean
    public EnterTransactionAction enterTransactionAction(EnterTransactions enterTransactions, Function<TransactionDto, Transaction> transactionDtoToTransactionMapper){
        return new EnterTransactionActionImpl(enterTransactions, transactionDtoToTransactionMapper);
    }
}
