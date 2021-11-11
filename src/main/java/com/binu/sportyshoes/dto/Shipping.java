package com.binu.sportyshoes.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shipping {

	@Id
	private String shippingCarrier;
	private String shippingType;
	private double costPerItem;
	
	public Shipping() {
		
	}

	public Shipping(String shippingCarrier, String shippingType, double costPerItem) {
		this.shippingCarrier = shippingCarrier;
		this.shippingType = shippingType;
		this.costPerItem = costPerItem;
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

	public double getCostPerItem() {
		return costPerItem;
	}

	public void setCostPerItem(double costPerItem) {
		this.costPerItem = costPerItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shippingCarrier == null) ? 0 : shippingCarrier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shipping other = (Shipping) obj;
		if (shippingCarrier == null) {
			if (other.shippingCarrier != null)
				return false;
		} else if (!shippingCarrier.equals(other.shippingCarrier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shipping [shippingCarrier=" + shippingCarrier + ", shippingType=" + shippingType + ", costPerItem="
				+ costPerItem + "]";
	}
	
	
}
