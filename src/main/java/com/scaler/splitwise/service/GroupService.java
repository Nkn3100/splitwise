package com.scaler.splitwise.service;

import com.scaler.splitwise.dto.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GroupService {
    List<TransactionDTO> settleUp();
}
