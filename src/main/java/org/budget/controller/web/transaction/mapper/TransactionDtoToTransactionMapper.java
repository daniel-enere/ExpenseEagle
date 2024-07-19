package org.budget.controller.web.transaction.mapper;

import org.budget.controller.web.transaction.dto.TransactionDto;
import org.budget.usecase.entity.Transaction;

import java.util.function.Function;

public class TransactionDtoToTransactionMapper implements Function<TransactionDto, Transaction> {
    @Override
    public Transaction apply(TransactionDto transactionDto) {
        transactionDto.setTrxEntryDate();
        return new Transaction(transactionDto.getAccount_id(), transactionDto.getAmount(), transactionDto.getCategory_id(), transactionDto.getTrxDate(), transactionDto.getTrxEntryDate());
    }
}
