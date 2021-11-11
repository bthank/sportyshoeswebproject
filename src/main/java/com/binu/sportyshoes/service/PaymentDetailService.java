package com.binu.sportyshoes.service;

import java.util.List;

import com.binu.sportyshoes.dto.PaymentDetail;

public interface PaymentDetailService {

	PaymentDetail getPaymentDetailById (int id);
	List<PaymentDetail> listOfAllPaymentDetail();
	PaymentDetail addPaymentDetail(PaymentDetail paymentDetail);
}
