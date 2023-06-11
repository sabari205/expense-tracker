package org.sabari.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sabari.expensetracker.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}