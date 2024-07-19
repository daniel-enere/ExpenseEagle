package org.budget.gateway.data.entity;

public enum AccountEntityType {
    cash("CASH"),
    checking("CHECKING"),
    savings("SAVINGS"),
    credit("CREDIT");

    private final String value;

    AccountEntityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

