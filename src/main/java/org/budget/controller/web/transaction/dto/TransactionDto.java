package org.budget.controller.web.transaction.dto;

public class TransactionDto {
    private int account_id;
    private int amount;
    private int category_id;
    private long trxDate;
    private long trxEntryDate;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public long getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(long trxDate) {
        this.trxDate = trxDate;
    }

    public long getTrxEntryDate() {
        return trxEntryDate;
    }

    public void setTrxEntryDate() {
        this.trxEntryDate = System.currentTimeMillis();
    }
}
