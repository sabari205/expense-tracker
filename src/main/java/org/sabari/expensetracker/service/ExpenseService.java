package org.sabari.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.sabari.expensetracker.models.Expense;
import org.sabari.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}
}