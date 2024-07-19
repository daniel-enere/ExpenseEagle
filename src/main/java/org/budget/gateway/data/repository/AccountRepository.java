package org.budget.gateway.data.repository;

import org.budget.gateway.data.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    @Override
    AccountEntity save(AccountEntity entity);
}
