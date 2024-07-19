package org.budget.controller.web.account.action;

import org.budget.controller.web.account.dto.AccountDto;
import org.springframework.http.ResponseEntity;

public interface GetAccountsAction {
    ResponseEntity<Iterable<AccountDto>> execute();
}
