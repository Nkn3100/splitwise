package com.scaler.splitwise.service.strategies;

import com.scaler.splitwise.dto.TransactionDTO;
import com.scaler.splitwise.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<TransactionDTO> settleUp(List<Expense> expenses);
}
