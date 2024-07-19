package org.budget.usecase.entity;

import java.util.function.Predicate;

public class Transaction {

    private final int account_id;
    private final int amount;
    private final int category_id;
    private final long trxDate;
    private final long trxEntryDate;

    public Transaction(int account_id, int amount, int category_id, long trxDate, long trxEntryDate) {
        this.account_id = account_id;
        this.amount = amount;
        this.category_id = category_id;
        this.trxDate = trxDate;
        this.trxEntryDate = trxEntryDate;
    }

    public int getAccount_id() {
        return account_id;
    }

    public int getAmount() {
        return amount;
    }

    public int getCategory_id() {
        return category_id;
    }

    public long getTrxDate() {
        return trxDate;
    }

    public long getTrxEntryDate() {
        return trxEntryDate;
    }
}
