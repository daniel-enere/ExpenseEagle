package org.budget.gateway.account;

import org.budget.gateway.data.entity.AccountEntity;
import org.budget.gateway.data.repository.AccountRepository;
import org.budget.usecase.gateway.account.SaveAccountGateway;

public class SaveAccountGatewayImpl implements SaveAccountGateway {
    private final AccountRepository accountRepository;

    public SaveAccountGatewayImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void execute(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }
}
