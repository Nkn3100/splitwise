package com.scaler.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "SPLITWISE_GROUP")
public class Group extends BaseModel{
    private String name;
    private String description;
    @ManyToMany(mappedBy = "groups")
    private List<User> users;
    @OneToMany
    private List<Expense> expenses;
    private double totalAmountSpend;

}
