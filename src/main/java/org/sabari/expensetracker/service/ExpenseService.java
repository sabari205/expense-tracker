package org.sabari.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Date;

import org.sabari.expensetracker.models.Expense;
import org.sabari.expensetracker.repository.ExpenseRepository;
import org.sabari.expensetracker.mapper.ExpenseDTOtoEntityMapper;
import org.sabari.expensetracker.dto.ExpenseDTO;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	@Autowired
	ExpenseDTOtoEntityMapper entityMapper;

	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	public List<Expense> getAllExpensesWithDate(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date searchDate = null;

		try {
			searchDate = new Date(df.parse(date).getTime());
			// System.out.println(df.parse(date).toString());
			// System.out.println(df.format(searchDate));
		} catch (ParseException ex) {
			return null;
		}

		return expenseRepository.findBySpentOn(searchDate);
	}

	public Expense addNewExpense(ExpenseDTO expense) {
		Expense insertedValue = entityMapper.dtoToEntityMapper(expense);

		System.out.println("From: " + expense.toString() + " to: " + insertedValue.toString());

		try {
			insertedValue = expenseRepository.save(insertedValue);
		} catch (IllegalArgumentException e) {
			return null;
		}

		return insertedValue;
	}

	public Expense updateExpense(ExpenseDTO expense) {
		Expense updatedExpense = expenseRepository.findById(expense.getId());

		entityMapper.dtoToEntityMapper(expense, updatedExpense);

		System.out.println("From: " + expense.toString() + " to: " + updatedExpense.toString());

		try {
			updatedExpense = expenseRepository.save(updatedExpense);
		} catch (IllegalArgumentException e) {
			return null;
		}

		return updatedExpense;
	}
}