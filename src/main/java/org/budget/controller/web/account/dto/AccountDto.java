package org.budget.controller.web.account.dto;

public class AccountDto {
    private long id;
    private String name;
    private String number;
    private String institution;
    private AccountDtoType accountDtoType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public AccountDtoType getAccountDtoType() {
        return accountDtoType;
    }

    public void setAccountDtoType(AccountDtoType accountDtoType) {
        this.accountDtoType = accountDtoType;
    }
}
