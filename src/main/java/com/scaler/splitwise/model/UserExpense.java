package com.scaler.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity(name = "SPLITWISE_USEREXPENSE")
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;


}
