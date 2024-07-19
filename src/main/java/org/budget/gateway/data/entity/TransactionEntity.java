package org.budget.gateway.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    private AccountEntity account;
    private double amount;

//    @ManyToOne
//    @JoinColumn(name = "category_subcategory_id", referencedColumnName = "id")
    @Column(name = "category_subcategory_id")
    private int category;

    @Column(name = "date")
    private long trxDate;

    @Column(name = "entry_date")
    private long trxEntryDate;

    public int getId() {
        return id;
    }

    public int getAccount_id() {
        return account.getId();
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCategory_id() {
        return category;
    }

    public void setCategory_id(int category) {
        this.category = category;
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

    public void setTrxEntryDate(long trxEntryDate) {
        this.trxEntryDate = trxEntryDate;
    }


}
