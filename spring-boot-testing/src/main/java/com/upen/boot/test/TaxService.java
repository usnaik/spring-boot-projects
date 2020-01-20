package com.upen.boot.test;

import java.util.List;

public class TaxService {

	public String getBracket(int income) {
		
		if (income < 1000)  return "LOW";
		else if (income < 5000) return "MEDIUM";
		else return "HIGH";
		
	}
	
	public List<String> getAllBrackets() {
		return List.newArrayList("LOW","MEDIUM","HIGH");
	}
}
