package com.sportyshoes.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/purchase")
	public ModelAndView purchase() {
		List<Purchase> purList = purchaseService.getAllPurchase();
		ModelAndView mav = new ModelAndView("Purchase");
		mav.addObject(purList);
		return mav;
	}
}
