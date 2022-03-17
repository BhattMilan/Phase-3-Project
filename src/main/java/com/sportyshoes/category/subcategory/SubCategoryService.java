package com.sportyshoes.category.subcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	public List<SubCategory> getAllSubCategories(){
		return subCategoryRepository.findAll();
	}

	public SubCategory saveSubCategory(SubCategory subCat) {
		return subCategoryRepository.save(subCat);
	}

	public List<SubCategory> getSubCategoryName(String subCatName) {
		return subCategoryRepository.findBySubCategoryName(subCatName);
	}

	public void deleteSubCategory(int subCatID) {
		subCategoryRepository.deleteById(subCatID);
	}
}
