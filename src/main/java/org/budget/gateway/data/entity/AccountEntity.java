package org.budget.gateway.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private byte id;
    private String name;

    @Enumerated(EnumType.STRING)
    private AccountEntityType type;
    private String number;
    private String institution;

    public byte getId() {
        return id;
    }

    public AccountEntityType getType() {
        return type;
    }

    public void setType(AccountEntityType type) {
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
