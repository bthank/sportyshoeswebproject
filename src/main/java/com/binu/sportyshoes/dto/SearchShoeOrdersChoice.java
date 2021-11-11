package com.binu.sportyshoes.dto;

public class SearchShoeOrdersChoice {
	
	private String dateOfOrderType;
	
	private String categoryOrderType;

	public SearchShoeOrdersChoice() {
		 
	}

	public String getDateOfOrderType() {
		return dateOfOrderType;
	}

	public void setDateOfOrderType(String dateOfOrderType) {
		this.dateOfOrderType = dateOfOrderType;
	}

	public String getCategoryOrderType() {
		return categoryOrderType;
	}

	public void setCategoryOrderType(String categoryOrderType) {
		this.categoryOrderType = categoryOrderType;
	}

	@Override
	public String toString() {
		return "SearchShoeOrdersChoice [dateOfOrderType=" + dateOfOrderType + ", categoryOrderType=" + categoryOrderType
				+ "]";
	}


	
}
