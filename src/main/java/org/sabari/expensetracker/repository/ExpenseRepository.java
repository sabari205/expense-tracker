package org.sabari.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

import org.sabari.expensetracker.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	List<Expense> findBySpentOn(Date date);
	Expense findById(int id);

}