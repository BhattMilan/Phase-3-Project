package com.sportyshoes.category.subcategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sportyshoes.category.Category;

@Entity
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subCatID", unique = true, nullable = false)
	private int subCatID;
	
	@ManyToOne
	@JoinColumn(name = "categoryID")
	private Category category;
	
	@Column(name = "subCategoryName", nullable = false)
	private String subCategoryName;
	
	public int getSubCatID() {
		return subCatID;
	}

	public void setSubCatID(int subCatID) {
		this.subCatID = subCatID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
}
