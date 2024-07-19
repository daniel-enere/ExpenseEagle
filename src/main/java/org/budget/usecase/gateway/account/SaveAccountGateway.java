package org.budget.usecase.gateway.account;

import org.budget.gateway.data.entity.AccountEntity;

public interface SaveAccountGateway {

    void execute(AccountEntity accountEntity);
}
