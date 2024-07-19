package org.budget.controller.web.transaction.action.impl;

import org.budget.controller.web.transaction.action.EnterTransactionAction;
import org.budget.controller.web.transaction.dto.TransactionDto;
import org.budget.usecase.entity.Transaction;
import org.budget.usecase.transaction.EnterTransactions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;
import java.util.stream.Stream;

public class EnterTransactionActionImpl implements EnterTransactionAction {
    private final EnterTransactions enterTransactions;
    private final Function<TransactionDto, Transaction> transactionDtoToTransactionMapper;

    public EnterTransactionActionImpl(EnterTransactions enterTransactions, Function<TransactionDto, Transaction> transactionDtoToTransactionMapper) {
        this.enterTransactions = enterTransactions;
        this.transactionDtoToTransactionMapper = transactionDtoToTransactionMapper;
    }

    @Override
    public ResponseEntity<String> execute(Stream<TransactionDto> transactionDtos) {
        System.err.println("it worked");
        enterTransactions.execute(transactionDtos.map(transactionDtoToTransactionMapper));
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaction entered");
    }
}
