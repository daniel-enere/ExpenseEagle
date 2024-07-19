package org.budget.controller.web.account.action.impl;

import org.budget.controller.web.account.action.GetAccountAction;
import org.budget.controller.web.account.dto.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetAccountActionImpl implements GetAccountAction {

    @Override
    public ResponseEntity<List<AccountDto>> execute(long accountId) {
        System.err.println("account id: "+ accountId);
        return ResponseEntity.ok(List.of(new AccountDto()));
    }
}
