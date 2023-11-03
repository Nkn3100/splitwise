package com.scaler.splitwise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@Entity(name = "SPLITWISE_EXPENSE")
public class Expense extends BaseModel{
    private String description;
    private double amount;
    @OneToMany
    private List<UserExpense> userExpenses;
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;

}
