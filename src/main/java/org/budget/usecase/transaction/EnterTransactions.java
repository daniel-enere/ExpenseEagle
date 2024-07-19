package org.budget.usecase.transaction;

import org.budget.usecase.entity.Transaction;
import java.util.stream.Stream;

public interface EnterTransactions {

    void execute(Stream<Transaction> transaction);
}
