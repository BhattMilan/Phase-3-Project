package com.sportyshoes.category.subcategory;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.category.Category;
import com.sportyshoes.category.CategoryService;

@RestController
public class SubCategoryController {

	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/subCategory")
	public ModelAndView subCategories(){
		List<SubCategory> subCategoryList = subCategoryService.getAllSubCategories();
		ModelAndView mav = new ModelAndView("SubCategory");
		mav.addObject(subCategoryList);
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addSubCategory")
	public ModelAndView addCategory() {
		return new ModelAndView("AddSubCategory");
	}

	@ModelAttribute("catList")
	public List<Category> getCats() {
		return categoryService.getAllCategory();
	}
	
	@ModelAttribute("subCatList")
	public List<SubCategory> getSubCats() {
		return subCategoryService.getAllSubCategories();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveSubCategory")
	public ModelAndView saveSubCategory(HttpServletRequest req) {
		String catName = null;
		SubCategory subCat = new SubCategory();
		subCat.setSubCategoryName(req.getParameter("subCategoryName"));
		
		catName = req.getParameter("selectCat");
		List<Category> catList = categoryService.getCategoryByName(catName);
		Category cat = new Category();
		cat.setCategoryID(catList.get(0).getCategoryID());
		
		subCat.setCategory(cat);
		SubCategory sc = subCategoryService.saveSubCategory(subCat);
		
		ModelAndView mav = null;
		if(sc.getSubCategoryName().equals(req.getParameter("subCategoryName"))) {
			mav = new ModelAndView("SuccessRecord");
		}
		else {
			mav = new ModelAndView("FailureRecord");
		}
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteSubCategory")
	public ModelAndView deleteSubCategory() {
		return new ModelAndView("DeleteSubCategory");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/subCatDeleteProcess")
	public ModelAndView deleteSubCatProcess(HttpServletRequest req, @RequestParam("id") int id) {
		ModelAndView mav = null;
		HttpSession session = req.getSession();
		if(session != null) {
			if(id != 0) {
				subCategoryService.deleteSubCategory(id);
				mav = new ModelAndView("DeleteRecSuccessfully");
			}
			else {
				mav = new ModelAndView("Login");
			}
		}
		return mav;
	}
}
