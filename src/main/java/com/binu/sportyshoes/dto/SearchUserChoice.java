package com.binu.sportyshoes.dto;

public class SearchUserChoice {

	private String genderType;
	
	private String ageType;
	
	public SearchUserChoice() {

	}
	
	public SearchUserChoice(String genderType, String ageType) {
		
		this.genderType = genderType;
		this.ageType = ageType;
	}



	public String getGenderType() {
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

	public String getAgeType() {
		return ageType;
	}

	public void setAgeType(String ageType) {
		this.ageType = ageType;
	}

	@Override
	public String toString() {
		return "SearchUserChoice [genderType=" + genderType + ", ageType=" + ageType + "]";
	}

	
	
}
