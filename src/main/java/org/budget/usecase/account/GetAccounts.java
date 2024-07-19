package org.budget.usecase.account;

import org.budget.usecase.entity.Account;

import java.util.stream.Stream;

public interface GetAccounts {
    Stream<Account> execute();
}
