package com.binu.sportyshoes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binu.sportyshoes.dto.PaymentDetail;
import com.binu.sportyshoes.repository.PaymentDetailRepository;

@Service
public class PaymentDetailServiceImpl implements PaymentDetailService {
	
	@Autowired
	PaymentDetailRepository paymentDetailRepository;

	@Override
	public PaymentDetail getPaymentDetailById(int id) {
		PaymentDetail paymentDetail = paymentDetailRepository.findById(id).get(); 
		return paymentDetail;
	}

	@Override
	public List<PaymentDetail> listOfAllPaymentDetail() {
		List<PaymentDetail> listOfAllPaymentDetail = paymentDetailRepository.findAll();
		return listOfAllPaymentDetail;
	}

	@Transactional
	@Override
	public PaymentDetail addPaymentDetail(PaymentDetail paymentDetail) {
		PaymentDetail savedPaymentDetail = paymentDetailRepository.save(paymentDetail);
		return savedPaymentDetail;
	}
	
	

}
