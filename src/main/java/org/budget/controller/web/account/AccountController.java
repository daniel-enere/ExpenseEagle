package org.budget.controller.web.account;

import org.budget.controller.web.account.action.CreateAccountAction;
import org.budget.controller.web.account.action.GetAccountAction;
import org.budget.controller.web.account.action.GetAccountsAction;
import org.budget.controller.web.account.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@CrossOrigin
public class AccountController {

    private final CreateAccountAction createAccountAction;
    private final GetAccountAction getAccountAction;
    private final GetAccountsAction getAccountsAction;

    public AccountController(CreateAccountAction createAccountAction, GetAccountAction getAccountAction, GetAccountsAction getAccountsAction) {
        this.createAccountAction = createAccountAction;
        this.getAccountAction = getAccountAction;
        this.getAccountsAction = getAccountsAction;
    }

    @GetMapping
    public ResponseEntity<Iterable<AccountDto>> getAll() {
        return getAccountsAction.execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AccountDto>> get(@PathVariable Long id) {
        System.err.println("id: "+ id);
        return getAccountAction.execute(id);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody AccountDto account) {
        System.err.println(account);
        return createAccountAction.execute(account);
    }

}
