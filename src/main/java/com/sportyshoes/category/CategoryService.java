package com.sportyshoes.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getCategoryByName(String catName){
		return categoryRepository.findByCategoryName(catName);
	}

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
}
