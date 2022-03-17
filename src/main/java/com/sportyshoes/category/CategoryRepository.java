package com.sportyshoes.category;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	public List<Category> findByCategoryName(String catName);
}
