package org.budget.controller.web.account.mapper;

import org.budget.controller.web.account.dto.AccountDto;
import org.budget.usecase.entity.Account;

import java.util.function.Function;

public class AccountDtoToAccountMapper implements Function<AccountDto, Account> {

    @Override
    public Account apply(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());
        account.setNumber(accountDto.getNumber());
        account.setInstitution(accountDto.getInstitution());
        account.setName(accountDto.getName());
        return account;
    }
}
