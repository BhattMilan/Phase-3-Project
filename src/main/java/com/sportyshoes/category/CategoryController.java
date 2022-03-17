package com.sportyshoes.category;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.category.subcategory.SubCategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/category")
	public ModelAndView getAllCategories() {
		List<Category> categoryList = categoryService.getAllCategory();
		ModelAndView mav = new ModelAndView("Category");
		mav.addObject(categoryList);
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addCategory")
	public ModelAndView addCategory() {
		return new ModelAndView("AddCategory");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveCategory")
	public ModelAndView saveCategory(HttpServletRequest req) {
		Category category = new Category();
		category.setCategoryName(req.getParameter("categoryName"));
		Category savedCat = categoryService.saveCategory(category);
		ModelAndView mav = null;
		if(savedCat.getCategoryName().equals(req.getParameter("categoryName"))) {
			mav = new ModelAndView("SuccessRecord");
		}
		else {
			mav = new ModelAndView("FailureRecord");
		}
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteCategory")
	public ModelAndView deleteCategory() {
		return new ModelAndView("DeleteCategory");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/catDeleteProcess")
	public ModelAndView deleteCatProcess(HttpServletRequest req, @RequestParam("id") int id) {
		ModelAndView mav = null;
		HttpSession session = req.getSession();
		if(session != null) {
			if(id != 0) {
				categoryService.deleteCategory(id);
				mav = new ModelAndView("DeleteRecSuccessfully");
			}
		}
		else {
			mav = new ModelAndView("Login");
		}
		return mav;
	}

	@ModelAttribute("catList")
	public List<Category> getCategory(){
		return categoryService.getAllCategory();
	}
}
