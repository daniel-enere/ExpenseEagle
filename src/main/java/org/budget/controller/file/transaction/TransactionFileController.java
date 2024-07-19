package org.budget.controller.file.transaction;

import org.budget.controller.file.transaction.action.ParseTransactionsAction;
import org.budget.usecase.entity.Transaction;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TransactionFileController {
    private final Logger logger = Logger.getLogger(TransactionFileController.class.getName());
    private final ParseTransactionsAction parseTransactionsAction;


    public TransactionFileController(ParseTransactionsAction parseTransactionsAction) {
        this.parseTransactionsAction = parseTransactionsAction;
    }

    public void execute(File transactionsFile){
        Stream<Transaction> transactions = parseTransactionsAction.execute(transactionsFile);
        //transform
        //load


        logger.log(Level.INFO, "");
    }
}
