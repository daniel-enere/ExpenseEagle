package org.budget.usecase.gateway.account;

import org.budget.gateway.data.entity.AccountEntity;

import java.util.Optional;

public interface GetAccountGateway {

    Optional<AccountEntity> execute(int id);
}
