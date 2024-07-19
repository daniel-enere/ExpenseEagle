package org.budget.controller.web.account.action.impl;

import org.budget.controller.web.account.action.CreateAccountAction;
import org.budget.controller.web.account.dto.AccountDto;
import org.budget.usecase.account.CreateAccount;
import org.budget.usecase.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;

public class CreateAccountActionImpl implements CreateAccountAction {
    private final CreateAccount createAccount;
    private final Function<AccountDto, Account> accountDtoToAccountMapper;

    public CreateAccountActionImpl(CreateAccount createAccount, Function<AccountDto, Account> accountDtoToAccountMapper) {
        this.createAccount = createAccount;
        this.accountDtoToAccountMapper = accountDtoToAccountMapper;
    }

    @Override
    public ResponseEntity<String> execute(AccountDto accountDto) {
        createAccount.execute(accountDtoToAccountMapper.apply(accountDto));
        return ResponseEntity.status(HttpStatus.CREATED).body("Account created");
    }
}
