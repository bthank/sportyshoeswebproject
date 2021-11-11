package com.binu.sportyshoes.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class ShoeOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String userName;
	
	private Date dateOfOrder;
	
	@OneToMany
	private List<OrderItem> orderItems;
	private String orderType; // 'Sneaker', 'Boot', 'Shoe', or 'Multitype'
	
	private String shippingCarrier;
	private String shippingChoice;
	
	private double orderBeforeTaxCost;
	private double orderTax;
	private double orderShippingCost;
	private double orderGrandTotal;
	private boolean shipped;
	private Date shippedDate;
	
	@OneToOne
	private PaymentDetail paymentDetail;
	
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date creationDate;
	
	@LastModifiedDate
	@Column(name = "last_updated_at", updatable = true)
	private Date lastUpdateDate;

	public ShoeOrder() {
		
	}

	public ShoeOrder(Integer id, String userName, Date dateOfOrder, List<OrderItem> orderItems, String orderType,
			String shippingCarrier, String shippingChoice, double orderBeforeTaxCost, double orderTax,
			double orderShippingCost, double orderGrandTotal, boolean shipped, Date shippedDate,
			PaymentDetail paymentDetail, Date creationDate, Date lastUpdateDate) {
		
		this.id = id;
		this.userName = userName;
		this.dateOfOrder = dateOfOrder;
		this.orderItems = orderItems;
		this.orderType = orderType;
		this.shippingCarrier = shippingCarrier;
		this.shippingChoice = shippingChoice;
		this.orderBeforeTaxCost = orderBeforeTaxCost;
		this.orderTax = orderTax;
		this.orderShippingCost = orderShippingCost;
		this.orderGrandTotal = orderGrandTotal;
		this.shipped = shipped;
		this.shippedDate = shippedDate;
		this.paymentDetail = paymentDetail;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public ShoeOrder(String userName, Date dateOfOrder, List<OrderItem> orderItems, String orderType,
			String shippingCarrier, String shippingChoice, double orderBeforeTaxCost, double orderTax,
			double orderShippingCost, double orderGrandTotal, boolean shipped, Date shippedDate,
			PaymentDetail paymentDetail, Date creationDate, Date lastUpdateDate) {
		
		this.userName = userName;
		this.dateOfOrder = dateOfOrder;
		this.orderItems = orderItems;
		this.orderType = orderType;
		this.shippingCarrier = shippingCarrier;
		this.shippingChoice = shippingChoice;
		this.orderBeforeTaxCost = orderBeforeTaxCost;
		this.orderTax = orderTax;
		this.orderShippingCost = orderShippingCost;
		this.orderGrandTotal = orderGrandTotal;
		this.shipped = shipped;
		this.shippedDate = shippedDate;
		this.paymentDetail = paymentDetail;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
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

	public double getOrderBeforeTaxCost() {
		return orderBeforeTaxCost;
	}

	public void setOrderBeforeTaxCost(double orderBeforeTaxCost) {
		this.orderBeforeTaxCost = orderBeforeTaxCost;
	}

	public double getOrderTax() {
		return orderTax;
	}

	public void setOrderTax(double orderTax) {
		this.orderTax = orderTax;
	}

	public double getOrderShippingCost() {
		return orderShippingCost;
	}

	public void setOrderShippingCost(double orderShippingCost) {
		this.orderShippingCost = orderShippingCost;
	}

	public double getOrderGrandTotal() {
		return orderGrandTotal;
	}

	public void setOrderGrandTotal(double orderGrandTotal) {
		this.orderGrandTotal = orderGrandTotal;
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

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ShoeOrder other = (ShoeOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoeOrder [id=" + id + ", userName=" + userName + ", dateOfOrder=" + dateOfOrder + ", orderItems="
				+ orderItems + ", orderType=" + orderType + ", shippingCarrier=" + shippingCarrier + ", shippingChoice="
				+ shippingChoice + ", orderBeforeTaxCost=" + orderBeforeTaxCost + ", orderTax=" + orderTax
				+ ", orderShippingCost=" + orderShippingCost + ", orderGrandTotal=" + orderGrandTotal + ", shipped="
				+ shipped + ", shippedDate=" + shippedDate + ", paymentDetail=" + paymentDetail + ", creationDate="
				+ creationDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}


	
	
	
}
