package org.budget.usecase.gateway.transaction;


import org.budget.usecase.entity.Transaction;
import java.util.stream.Stream;

public interface SaveTransactionsGateway {

    void execute(Stream<Transaction> transactions);
}
