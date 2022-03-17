package com.sportyshoes.product;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sportyshoes.purchase.Purchase;

@Entity
@Table(name = "product")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productID", unique = true, nullable = false)
	private int productID;
	
	@Column(name = "subCatID", nullable = false)
	private int subCatID;
	
	@Column(name = "productName", nullable = false)
	private String productName;
	
//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Purchase.class)
//	@JoinColumn(name = "purchaseID")
//	private Purchase purchase;
	
	public int getSubCatID() {
		return subCatID;
	}

	public void setSubCatID(int subCatID) {
		this.subCatID = subCatID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String procutName) {
		this.productName = procutName;
	}

//	public Purchase getPurchase() {
//		return purchase;
//	}
//
//	public void setPurchase(Purchase purchase) {
//		this.purchase = purchase;
//	}
	
}