package org.budget.controller.web.account.action;

import org.budget.controller.web.account.dto.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetAccountAction {

    ResponseEntity<List<AccountDto>> execute(long accountId);
}
