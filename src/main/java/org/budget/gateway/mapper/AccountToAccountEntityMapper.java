package org.budget.gateway.mapper;

import org.budget.gateway.data.entity.AccountEntity;
import org.budget.usecase.entity.Account;

import java.util.function.Function;

public class AccountToAccountEntityMapper implements Function<Account, AccountEntity> {
    @Override
    public AccountEntity apply(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(account.getName());
//        accountEntity.setBalance(account.getBalance());
//        accountEntity.setAccountDtoType(account.getAccountDtoType());
        return accountEntity;
    }
}
