package org.budget.controller.file.transaction.action;

import org.budget.usecase.entity.Transaction;

import java.io.File;
import java.util.stream.Stream;

public interface ParseTransactionsAction {

    Stream<Transaction> execute(File file);
}
