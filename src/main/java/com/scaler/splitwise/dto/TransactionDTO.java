package com.scaler.splitwise.dto;


import lombok.*;

@Data //getter, setter, noArgsConstructor, toString()
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private String fromUserName;
    private String toUserName;
    private double amount;

}
