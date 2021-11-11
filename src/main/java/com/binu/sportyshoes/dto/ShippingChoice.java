package com.binu.sportyshoes.dto;

public class ShippingChoice {
	
	private String shippingCarrier;
	private String shippingType;
	
	public ShippingChoice() {
		
	}

	public ShippingChoice(String shippingCarrier, String shippingType) {
		 
		this.shippingCarrier = shippingCarrier;
		this.shippingType = shippingType;
	}

	public String getShippingCarrier() {
		return shippingCarrier;
	}

	public void setShippingCarrier(String shippingCarrier) {
		this.shippingCarrier = shippingCarrier;
	}

	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	@Override
	public String toString() {
		return "ShippingChoice [shippingCarrier=" + shippingCarrier + ", shippingType=" + shippingType + "]";
	}
	
	
	

}
