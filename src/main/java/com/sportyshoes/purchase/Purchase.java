package com.sportyshoes.purchase;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sportyshoes.product.Product;
import com.sportyshoes.user.User;

@Entity
@Table(name = "purchase")
public class Purchase implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchaseID", unique = true, nullable = false)
	private int purchaseID;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="productID")
	private Set<Product> product;
	
	
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "userID")
	private User user;
	
	@Column(name = "createdDate")
	private Date createdDate;

	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
