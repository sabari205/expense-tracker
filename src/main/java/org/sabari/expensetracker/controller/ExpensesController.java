package org.sabari.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.sabari.expensetracker.service.ExpenseService;
import org.sabari.expensetracker.models.Expense;

@RestController
@RequestMapping("/api")
public class ExpensesController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("expenses")
    public ResponseEntity<List<Expense>> getAll () {
        List<Expense> result = expenseService.getAllExpenses();
        
        if (result.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}