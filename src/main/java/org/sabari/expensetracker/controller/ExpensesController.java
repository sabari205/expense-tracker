package org.sabari.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import org.sabari.expensetracker.service.ExpenseService;
import org.sabari.expensetracker.models.Expense;
import org.sabari.expensetracker.dto.ExpenseDTO;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/")
    public ResponseEntity<List<Expense>> getAll () {
        List<Expense> result = expenseService.getAllExpenses();
        
        if (result.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Expense>> getExpensesWithDate(@RequestParam(value="date") String date) {
        List<Expense> filteredByDate = expenseService.getAllExpensesWithDate(date);

        if (filteredByDate == null) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(filteredByDate, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseDTO expense) {
        Expense newValue = null;

        newValue = expenseService.addNewExpense(expense);

        if (newValue == null) {
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity(newValue, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody ExpenseDTO expense) {
        Expense updatedExpense = null;

        updatedExpense = expenseService.updateExpense(expense);

        if (updatedExpense == null) {
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity(updatedExpense, HttpStatus.OK);
    }
}