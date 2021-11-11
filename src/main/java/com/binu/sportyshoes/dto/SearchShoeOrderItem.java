package com.binu.sportyshoes.dto;

import java.sql.Date;

public class SearchShoeOrderItem {

	private Integer shoeOrderId;
	private String userName;
	private Date dateOfOrder;
    private String orderType; 
	
	private Integer orderItemId;
	private Integer shoeId;
	private String shoeName;
	private Integer purchaseQuantity;
	private String imageUrl;
	private double price;
	
	private String shippingCarrier;
	private String shippingChoice;
	private boolean shipped;
	private Date shippedDate;
	
	public SearchShoeOrderItem() {
		 
	}

	public Integer getShoeOrderId() {
		return shoeOrderId;
	}

	public void setShoeOrderId(Integer shoeOrderId) {
		this.shoeOrderId = shoeOrderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
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

	public String getShippingCarrier() {
		return shippingCarrier;
	}

	public void setShippingCarrier(String shippingCarrier) {
		this.shippingCarrier = shippingCarrier;
	}

	public String getShippingChoice() {
		return shippingChoice;
	}

	public void setShippingChoice(String shippingChoice) {
		this.shippingChoice = shippingChoice;
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	@Override
	public String toString() {
		return "SearchShoeOrderItem [shoeOrderId=" + shoeOrderId + ", userName=" + userName + ", dateOfOrder="
				+ dateOfOrder + ", orderType=" + orderType + ", orderItemId=" + orderItemId + ", shoeId=" + shoeId
				+ ", shoeName=" + shoeName + ", purchaseQuantity=" + purchaseQuantity + ", imageUrl=" + imageUrl
				+ ", price=" + price + ", shippingCarrier=" + shippingCarrier + ", shippingChoice=" + shippingChoice
				+ ", shipped=" + shipped + ", shippedDate=" + shippedDate + "]";
	}
	
	
}
