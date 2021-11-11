package com.binu.sportyshoes.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shoe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String stockId;
	private String shoeName;
	private String shoeType;
	private String brand;	
	private String color;
	private int quantityOnHand;
	private String gender;
	private String size;
	private double inventoryCost;
	private double marketPrice;
	private String countryOfManufacture;
	private String imageUrl;
	
	public Shoe() {
		 
	}

	public Shoe(Integer id, String stockId, String shoeName, String shoeType, String brand, String color,
			int quantityOnHand, String gender, String size, double inventoryCost, double marketPrice,
			String countryOfManufacture, String imageUrl) {
		 
		this.id = id;
		this.stockId = stockId;
		this.shoeName = shoeName;
		this.shoeType = shoeType;
		this.brand = brand;
		this.color = color;
		this.quantityOnHand = quantityOnHand;
		this.gender = gender;
		this.size = size;
		this.inventoryCost = inventoryCost;
		this.marketPrice = marketPrice;
		this.countryOfManufacture = countryOfManufacture;
		this.imageUrl = imageUrl;
	}

	public Shoe(String stockId, String shoeName, String shoeType, String brand, String color, int quantityOnHand,
			String gender, String size, double inventoryCost, double marketPrice, String countryOfManufacture,
			String imageUrl) {
		 
		this.stockId = stockId;
		this.shoeName = shoeName;
		this.shoeType = shoeType;
		this.brand = brand;
		this.color = color;
		this.quantityOnHand = quantityOnHand;
		this.gender = gender;
		this.size = size;
		this.inventoryCost = inventoryCost;
		this.marketPrice = marketPrice;
		this.countryOfManufacture = countryOfManufacture;
		this.imageUrl = imageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getShoeName() {
		return shoeName;
	}

	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	public String getShoeType() {
		return shoeType;
	}

	public void setShoeType(String shoeType) {
		this.shoeType = shoeType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getInventoryCost() {
		return inventoryCost;
	}

	public void setInventoryCost(double inventoryCost) {
		this.inventoryCost = inventoryCost;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getCountryOfManufacture() {
		return countryOfManufacture;
	}

	public void setCountryOfManufacture(String countryOfManufacture) {
		this.countryOfManufacture = countryOfManufacture;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((shoeName == null) ? 0 : shoeName.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
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
		Shoe other = (Shoe) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (shoeName == null) {
			if (other.shoeName != null)
				return false;
		} else if (!shoeName.equals(other.shoeName))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", stockId=" + stockId + ", shoeName=" + shoeName + ", shoeType=" + shoeType
				+ ", brand=" + brand + ", color=" + color + ", quantityOnHand=" + quantityOnHand + ", gender=" + gender
				+ ", size=" + size + ", inventoryCost=" + inventoryCost + ", marketPrice=" + marketPrice
				+ ", countryOfManufacture=" + countryOfManufacture + ", imageUrl=" + imageUrl + "]";
	}


		
	
}
