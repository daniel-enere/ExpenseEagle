package org.budget.usecase.impl;

import org.budget.gateway.data.entity.AccountEntity;
import org.budget.usecase.account.CreateAccount;
import org.budget.usecase.account.impl.CreateAccountImpl;
import org.budget.usecase.entity.Account;
import org.budget.usecase.gateway.account.SaveAccountGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Function;

@ExtendWith(MockitoExtension.class)
class CreateAccountImplTest {

    @Mock
    private SaveAccountGateway saveAccountGateway;
    @Mock
    private Function<Account, AccountEntity> accountToAccountEntityMapper;
    private CreateAccount createAccount;

    @BeforeEach
    void setUp() {
        createAccount = new CreateAccountImpl(saveAccountGateway, accountToAccountEntityMapper);
    }

    @Test
    void executeShouldCreateAccount() {
        Account account = Mockito.mock(Account.class);
        AccountEntity expected = Mockito.mock(AccountEntity.class);
        Mockito.when(accountToAccountEntityMapper.apply(account)).thenReturn(expected);
        createAccount.execute(account);

        Mockito.verify(saveAccountGateway).execute(Mockito.mock(AccountEntity.class));
    }
}