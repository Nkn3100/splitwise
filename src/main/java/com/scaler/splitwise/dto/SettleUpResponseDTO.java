package com.scaler.splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data //getter, setter, noArgsConstructor, toString()
@AllArgsConstructor
public class SettleUpResponseDTO {
    private List<TransactionDTO> transactionList;
}
