package com.scaler.splitwise.service;

import com.scaler.splitwise.dto.TransactionDTO;
import com.scaler.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    UserRepository userRepository; //ideal way should be to call a method in user service that calls the user repository to get the users
    @Override
    public List<TransactionDTO> settleUp() {
        return null;
    }
}
