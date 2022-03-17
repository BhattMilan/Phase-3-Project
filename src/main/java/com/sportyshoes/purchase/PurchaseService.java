package com.sportyshoes.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

	@Autowired
	PurchaseRepository purchaseRepository;
	
	public List<Purchase> getAllPurchase(){
		return purchaseRepository.findAll();
	}
}
