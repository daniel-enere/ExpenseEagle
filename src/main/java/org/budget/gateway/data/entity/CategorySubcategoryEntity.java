package org.budget.gateway.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category_subcategory")
public class CategorySubcategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Other fields and methods...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Other getter and setter methods...
}
