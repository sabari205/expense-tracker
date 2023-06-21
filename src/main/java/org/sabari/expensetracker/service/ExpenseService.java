package org.sabari.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Date;

import org.sabari.expensetracker.models.Expense;
import org.sabari.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

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

	public Expense addNewExpense(Expense expense) {
		Expense insertedValue = null;

		try {
			insertedValue = expenseRepository.save(expense);
		} catch (IllegalArgumentException e) {
			return null;
		}

		return insertedValue;
	}
}