package org.budget.gateway.account;

import org.budget.gateway.data.entity.AccountEntity;
import org.budget.gateway.data.repository.AccountRepository;
import org.budget.usecase.gateway.account.GetAccountsGateway;

public class GetAccountsGatewayImpl implements GetAccountsGateway {
    private final AccountRepository accountRepository;

    public GetAccountsGatewayImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Iterable<AccountEntity> execute() {
        return accountRepository.findAll();
    }
}
