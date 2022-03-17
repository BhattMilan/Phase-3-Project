package com.sportyshoes.category.subcategory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer>{

	public List<SubCategory> findBySubCategoryName(String subCatName);

}
