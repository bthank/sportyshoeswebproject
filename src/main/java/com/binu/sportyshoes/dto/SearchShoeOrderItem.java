package com.binu.sportyshoes.dto;

import java.sql.Date;

public class SearchShoeOrderItem {

	private Integer shoeOrderId;
	private String userName;
	private Date dateOfOrder;
    private String orderType; 
	
    /*
 	private Integer orderItemId;
	private Integer shoeId;
	private String shoeName;
	private Integer purchaseQuantity;
	private String imageUrl;
	private double price;
 */
	
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
				+ dateOfOrder + ", orderType=" + orderType + ", shippingCarrier=" + shippingCarrier
				+ ", shippingChoice=" + shippingChoice + ", shipped=" + shipped + ", shippedDate=" + shippedDate + "]";
	}


}
