package com.scaler.splitwise.service.strategies;

import com.scaler.splitwise.dto.TransactionDTO;
import com.scaler.splitwise.model.Expense;
import com.scaler.splitwise.model.User;
import com.scaler.splitwise.model.UserExpense;
import com.scaler.splitwise.model.UserExpenseType;

import java.util.*;

public class HeapBasedSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<TransactionDTO> settleUp(List<Expense> expenses) {
        HashMap<User, Double> userOutstandingMap = new HashMap<>();
        List<TransactionDTO> transactionList = new ArrayList<>();
        //for loop below calculates the outstanding amount for each user in the group [all users in the list of expense]
        for(Expense expense: expenses){
            for(UserExpense userExpense: expense.getUserExpenses()){
                User user = userExpense.getUser();
                double currentOutstandingAmount = userOutstandingMap.getOrDefault(user, 0.00);
                userOutstandingMap.put(user, getUpdatedOutStandingAmount(currentOutstandingAmount,userExpense));
            }
        }
        //maxHeap for all PAID users [ +ve balance ]
        PriorityQueue<Map.Entry<User, Double>> maxHeap = new PriorityQueue<>(
                (a,b) -> Double.compare(b.getValue(),a.getValue())
        );
        //minHeap for all hasToPay users [ -ve balance ]
        PriorityQueue<Map.Entry<User, Double>> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(Map.Entry::getValue)
        );
        for(Map.Entry<User,Double> entry : userOutstandingMap.entrySet()){
            if(entry.getValue() < 0){
                minHeap.add(entry);
            }else if(entry.getValue() > 0){
                maxHeap.add(entry);
            }else{
                System.out.println(entry.getKey().getName() + " is already settled, no need to be part of transactions");
            }
        }
        while (!minHeap.isEmpty()){
            Map.Entry<User,Double> maxHasToPay = minHeap.poll();
            Map.Entry<User,Double> maxPaid = maxHeap.poll();
            TransactionDTO transaction = new TransactionDTO(
                    maxHasToPay.getKey().getName(),
                    maxPaid.getKey().getName(),
                    Math.abs(maxHasToPay.getValue()) >= Math.abs(maxPaid.getValue()) ?
                            Math.abs(maxHasToPay.getValue()) : Math.abs(maxPaid.getValue()));
            transactionList.add(transaction);
            double outStanding = maxPaid.getValue() + maxHasToPay.getValue();
            if(outStanding < 0){
                maxHasToPay.setValue(outStanding);
                minHeap.add(maxHasToPay);
            }else if(outStanding > 0){
                maxPaid.setValue(outStanding);
                maxHeap.add(maxPaid);
            }else{
                System.out.println("Settled");
            }
        }

        return transactionList;
    }
    private double getUpdatedOutStandingAmount(double currentOutStandingAmount, UserExpense userExpense){
        if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID)){
            currentOutStandingAmount += userExpense.getAmount();
        }else{
            currentOutStandingAmount -= userExpense.getAmount();
        }
        return currentOutStandingAmount;
    }
    /*
    Go through all the expenses and find the outstanding amount for each user
    a.Loop through each expense, and for each expense
    b. We will loop through all the userExpense
    If userExpense type is PAID, it will be added as +Ve
    If userExpense type is HAS_TO_PAY, it will be subtracted as -Ve
    from each user.
    2. All the users with negative balance [hasToPay] -> minHeap
    3. ALl the users with positive balance [paid] -> maxHeap
    4. We will find the transactions

     */
}
