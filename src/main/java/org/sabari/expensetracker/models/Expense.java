package org.sabari.expensetracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="description")
	private String description;

	@Column(name="spenton")
	private Date spentOn;

	@Column(name="amount")
	private float amount;

	@Column(name="username")
	private String username;

	public Expense() {

	}

	public Expense(String description, Date spentOn, float amount, String username) {
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
		return String.format("Expenses (%d, %s, %s, %.3f, %s)", id, description, new SimpleDateFormat("YYYY-MM-DD").format(spentOn), amount, username);
	}
}