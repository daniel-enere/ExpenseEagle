package org.budget.gateway.account;

import org.budget.gateway.data.entity.AccountEntity;
import org.budget.gateway.data.repository.AccountRepository;
import org.budget.usecase.gateway.account.GetAccountGateway;

import java.util.Optional;

public class GetAccountGatewayImpl implements GetAccountGateway {
    private final AccountRepository accountRepository;

    public GetAccountGatewayImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<AccountEntity> execute(int id) {
        return accountRepository.findById(id);
    }
}
