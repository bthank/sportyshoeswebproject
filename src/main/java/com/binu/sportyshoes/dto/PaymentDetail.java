package com.binu.sportyshoes.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PaymentDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
		
	private String payerFirstName;
	private String payerLastName;
	
	@OneToOne
	private Address billingAddress;
	
	private String billingPhoneNo;
	
	private String paymentType; // 1=Credit Card, 2=Debit Card
	private String cardNo;
	private String cardExpirationMonth;
	private String cardExpirationYear;
	private String cardCvvCode;
	
	public PaymentDetail() {
		
	}

	public PaymentDetail(Integer id, String payerFirstName, String payerLastName, Address billingAddress,
			String billingPhoneNo, String paymentType, String cardNo, String cardExpirationMonth,
			String cardExpirationYear, String cardCvvCode) {
		 
		this.id = id;
		this.payerFirstName = payerFirstName;
		this.payerLastName = payerLastName;
		this.billingAddress = billingAddress;
		this.billingPhoneNo = billingPhoneNo;
		this.paymentType = paymentType;
		this.cardNo = cardNo;
		this.cardExpirationMonth = cardExpirationMonth;
		this.cardExpirationYear = cardExpirationYear;
		this.cardCvvCode = cardCvvCode;
	}

	public PaymentDetail(String payerFirstName, String payerLastName, Address billingAddress, String billingPhoneNo,
			String paymentType, String cardNo, String cardExpirationMonth, String cardExpirationYear,
			String cardCvvCode) {
		 
		this.payerFirstName = payerFirstName;
		this.payerLastName = payerLastName;
		this.billingAddress = billingAddress;
		this.billingPhoneNo = billingPhoneNo;
		this.paymentType = paymentType;
		this.cardNo = cardNo;
		this.cardExpirationMonth = cardExpirationMonth;
		this.cardExpirationYear = cardExpirationYear;
		this.cardCvvCode = cardCvvCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayerFirstName() {
		return payerFirstName;
	}

	public void setPayerFirstName(String payerFirstName) {
		this.payerFirstName = payerFirstName;
	}

	public String getPayerLastName() {
		return payerLastName;
	}

	public void setPayerLastName(String payerLastName) {
		this.payerLastName = payerLastName;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingPhoneNo() {
		return billingPhoneNo;
	}

	public void setBillingPhoneNo(String billingPhoneNo) {
		this.billingPhoneNo = billingPhoneNo;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardExpirationMonth() {
		return cardExpirationMonth;
	}

	public void setCardExpirationMonth(String cardExpirationMonth) {
		this.cardExpirationMonth = cardExpirationMonth;
	}

	public String getCardExpirationYear() {
		return cardExpirationYear;
	}

	public void setCardExpirationYear(String cardExpirationYear) {
		this.cardExpirationYear = cardExpirationYear;
	}

	public String getCardCvvCode() {
		return cardCvvCode;
	}

	public void setCardCvvCode(String cardCvvCode) {
		this.cardCvvCode = cardCvvCode;
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
		PaymentDetail other = (PaymentDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaymentDetail [id=" + id + ", payerFirstName=" + payerFirstName + ", payerLastName=" + payerLastName
				+ ", billingAddress=" + billingAddress + ", billingPhoneNo=" + billingPhoneNo + ", paymentType="
				+ paymentType + ", cardNo=" + cardNo + ", cardExpirationMonth=" + cardExpirationMonth
				+ ", cardExpirationYear=" + cardExpirationYear + ", cardCvvCode=" + cardCvvCode + "]";
	}


	
}
