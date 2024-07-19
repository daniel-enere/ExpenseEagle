package org.budget.usecase.account.impl;

import org.budget.usecase.account.GetAccounts;
import org.budget.usecase.entity.Account;
import org.budget.usecase.gateway.account.GetAccountsGateway;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class GetAccountsImpl implements GetAccounts {
    private final GetAccountsGateway getAccountsGateway;

    public GetAccountsImpl(GetAccountsGateway getAccountsGateway) {
        this.getAccountsGateway = getAccountsGateway;
    }

    @Override
    public Stream<Account> execute() {
        return StreamSupport.stream(getAccountsGateway.execute().spliterator(), false).map(
                accountEntity -> {
                    Account account = new Account();
                    account.setId(accountEntity.getId());
                    account.setName(accountEntity.getName());
                    account.setInstitution(accountEntity.getInstitution());
                    account.setNumber(accountEntity.getNumber());
                    //TODO add account type mapping
                    return account;
                }
        );
    }
}
