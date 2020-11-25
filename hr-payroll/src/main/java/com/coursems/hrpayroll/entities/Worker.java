package com.coursems.hrpayroll.entities;

import java.io.Serializable;

public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	private Long id;
	private String name;
	private Double dailyIncome;	
	
	public Worker() {}

	public Worker(String name, Double dailyIncome) {
		this.name = name;
		this.dailyIncome = dailyIncome;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}
}
