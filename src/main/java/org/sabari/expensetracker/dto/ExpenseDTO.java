package org.sabari.expensetracker.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ExpenseDTO {
	private int id;
	private String description;
	private Date spentOn;
	private float amount;
	private String username;

	public ExpenseDTO() {

	}

	public ExpenseDTO(int id, String description, Date spentOn, float amount, String username) {
		this.description = description;
		this.spentOn = spentOn;
		this.amount = amount;
		this.username = username;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getSpentOn() {
		return this.spentOn;
	}

	public Date getSpentOnDate() throws ParseException {
		// return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(this.spentOn).getTime());
		return this.spentOn;
	}

	public void setSpentOn(Date spentOn) {
		this.spentOn = spentOn;
	}
	
	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String toString() {
		return String.format("ExpensesDTO (%s, %s, %.3f, %s)", description, spentOn, amount, username);
	}
}