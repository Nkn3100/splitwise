package com.scaler.splitwise.controller;

import com.scaler.splitwise.dto.SettleUpResponseDTO;
import com.scaler.splitwise.dto.TransactionDTO;
import com.scaler.splitwise.service.GroupService;
import com.scaler.splitwise.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettleUpController {
    @Autowired
    private InitService initService;
    @Autowired
    private GroupService groupService;

    @GetMapping("/init")
    public ResponseEntity initialise(){
        initService.initialise();

        return ResponseEntity.ok("DONE");

    }
    @GetMapping("/settleUp")
    public ResponseEntity settleUp(){
        List<TransactionDTO> transactionDTOS = groupService.settleUp();
        return ResponseEntity.ok(transactionDTOS);

    }

}
