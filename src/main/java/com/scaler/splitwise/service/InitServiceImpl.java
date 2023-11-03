package com.scaler.splitwise.service;

import com.scaler.splitwise.model.*;
import com.scaler.splitwise.repository.ExpenseRepository;
import com.scaler.splitwise.repository.GroupRepository;
import com.scaler.splitwise.repository.UserExpenseRepository;
import com.scaler.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserExpenseRepository userExpenseRepository;
    @Override
    public void initialise() {
        User archana = User.builder().email("archana@gmail.com").phoneNumber("123456789").name("Archana Hareendran").build();
        User nikhil = User.builder().email("nikhil@gmail.com").phoneNumber("123456788").name("Nikhil Krishnan").build();
        User gokul = User.builder().email("gokul@gmail.com").phoneNumber("123456787").name("Gokul Krishnan").build();
        User anjali = User.builder().email("anjali@gmail.com").phoneNumber("123456786").name("Anjali Gopan").build();
        archana = userRepository.save(archana);
        nikhil = userRepository.save(nikhil);
        gokul = userRepository.save(gokul);
        anjali = userRepository.save(anjali);

        Group group = new Group();
        group.setDescription("Friends who never pay back on time");
        group.setName("Trip to Manali");
        group.setUsers(List.of(archana, nikhil, gokul, anjali));
        group = groupRepository.save(group);

        //4 expenses
        //Expense 1 -> amount 1000 paid by Archana hasToPay : everyone equal
        UserExpense userExpense = new UserExpense();
        userExpense.setUser(archana);
        userExpense.setAmount(1000);
        userExpense.setUserExpenseType(UserExpenseType.PAID);
        userExpense = userExpenseRepository.save(userExpense);

        UserExpense userExpense1 = new UserExpense();
        userExpense1.setUser(gokul);
        userExpense1.setAmount(250);
        userExpense1.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense1 = userExpenseRepository.save(userExpense1);

        UserExpense userExpense2 = new UserExpense();
        userExpense2.setUser(anjali);
        userExpense2.setAmount(250);
        userExpense2.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense2 = userExpenseRepository.save(userExpense2);

        UserExpense userExpense3 = new UserExpense();
        userExpense3.setUser(nikhil);
        userExpense3.setAmount(250);
        userExpense3.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense3 = userExpenseRepository.save(userExpense3);

        UserExpense userExpense4 = new UserExpense();
        userExpense4.setUser(archana);
        userExpense4.setAmount(250);
        userExpense4.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense4 = userExpenseRepository.save(userExpense4);

        Expense expense = new Expense();
        expense.setAmount(1000);
        expense.setDescription("Dinner");
        expense.setCurrency(Currency.INR);
        expense.setUserExpenses(List.of(userExpense1,userExpense2,userExpense3,userExpense4,userExpense));
        expenseRepository.save(expense);


    }
}
