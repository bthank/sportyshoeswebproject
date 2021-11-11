package com.binu.sportyshoes.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer shoeId;
	private String shoeName;
	private Integer purchaseQuantity;
	private String imageUrl;
	private double price;
	
	public OrderItem() {
		
	}

	public OrderItem(Integer id, Integer shoeId, String shoeName, Integer purchaseQuantity, String imageUrl,
			double price) {
		 
		this.id = id;
		this.shoeId = shoeId;
		this.shoeName = shoeName;
		this.purchaseQuantity = purchaseQuantity;
		this.imageUrl = imageUrl;
		this.price = price;
	}

	public OrderItem(Integer shoeId, String shoeName, Integer purchaseQuantity, String imageUrl, double price) {
		super();
		this.shoeId = shoeId;
		this.shoeName = shoeName;
		this.purchaseQuantity = purchaseQuantity;
		this.imageUrl = imageUrl;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShoeId() {
		return shoeId;
	}

	public void setShoeId(Integer shoeId) {
		this.shoeId = shoeId;
	}

	public String getShoeName() {
		return shoeName;
	}

	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((shoeId == null) ? 0 : shoeId.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shoeId == null) {
			if (other.shoeId != null)
				return false;
		} else if (!shoeId.equals(other.shoeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", shoeId=" + shoeId + ", shoeName=" + shoeName + ", purchaseQuantity="
				+ purchaseQuantity + ", imageUrl=" + imageUrl + ", price=" + price + "]";
	}


}
