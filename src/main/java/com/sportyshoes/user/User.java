package com.sportyshoes.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sportyshoes.purchase.Purchase;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID", unique = true, nullable = false)
	private int userID;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "isSystemAdmin", nullable = false)
	private int isSystemAdmin;
	
	@Column(name = "createdDate", nullable = false)
	private Date createdDate;
	
	@Column(name = "modifieddate", nullable = false)
	private Date modifiedDate;

	@OneToMany(mappedBy = "user")
	private Set<Purchase> purchase;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsSystemAdmin() {
		return isSystemAdmin;
	}

	public void setIsSystemAdmin(int isSystemAdmin) {
		this.isSystemAdmin = isSystemAdmin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Set<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(Set<Purchase> purchase) {
		this.purchase = purchase;
	}

}
