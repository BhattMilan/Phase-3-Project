package com.sportyshoes.category;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.sportyshoes.category.subcategory.SubCategory;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryID", unique = true, nullable = false)
	private int categoryID;
	
	@Column(name = "categoryName", nullable = false)
	private String categoryName;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<SubCategory> subCategory;

	public Set<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
