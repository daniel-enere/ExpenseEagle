package org.budget.controller.web.account.action.impl;

import org.budget.controller.web.account.action.GetAccountsAction;
import org.budget.controller.web.account.dto.AccountDto;
import org.budget.usecase.account.GetAccounts;
import org.springframework.http.ResponseEntity;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class GetAccountsActionImpl implements GetAccountsAction {
    private final GetAccounts getAccounts;

    public GetAccountsActionImpl(GetAccounts getAccounts) {
        this.getAccounts = getAccounts;
    }

    @Override
    public ResponseEntity<Iterable<AccountDto>> execute() {
        return ResponseEntity.ok(StreamSupport.stream(getAccounts.execute().spliterator(), false).map(account -> {
            AccountDto accountDto = new AccountDto();
            accountDto.setName(account.getName());
            accountDto.setId(account.getId());
            accountDto.setInstitution(account.getInstitution());
            accountDto.setNumber(account.getNumber());
            return accountDto;
        }).collect(Collectors.toSet()));
    }
}
