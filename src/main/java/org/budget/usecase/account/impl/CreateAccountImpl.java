package org.budget.usecase.account.impl;

import org.budget.gateway.data.entity.AccountEntity;
import org.budget.usecase.account.CreateAccount;
import org.budget.usecase.entity.Account;
import org.budget.usecase.gateway.account.SaveAccountGateway;

import java.util.function.Function;

public class CreateAccountImpl implements CreateAccount {
    private final SaveAccountGateway saveAccountGateway;
    private final Function<Account, AccountEntity> accountToAccountEntityMapper;

    public CreateAccountImpl(SaveAccountGateway saveAccountGateway, Function<Account, AccountEntity> accountToAccountEntityMapper) {
        this.saveAccountGateway = saveAccountGateway;
        this.accountToAccountEntityMapper = accountToAccountEntityMapper;
    }

    @Override
    public void execute(Account account) {
        saveAccountGateway.execute(accountToAccountEntityMapper.apply(account));
    }
}
