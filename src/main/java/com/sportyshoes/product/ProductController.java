package com.sportyshoes.product;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.sportyshoes.category.subcategory.SubCategory;
import com.sportyshoes.category.subcategory.SubCategoryService;
import com.sportyshoes.image.Image;
import com.sportyshoes.image.ImageService;
import com.sportyshoes.user.UserService;

@RestController
public class ProductController {

	HttpSession session;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;

	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	ImageService imageService;
	
	@RequestMapping(method = RequestMethod.GET, value = {"/dashboard"})
	public ModelAndView getHome(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = null;
		session = req.getSession(false);
		if(session != null)
			mav = new ModelAndView("Dashboard");
		else
			mav = new ModelAndView("Login");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = {"/getImg"})
	@ResponseBody
	public byte[] getImage(@RequestParam("id") int id) {
		return productService.getImage(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public ModelAndView getProducts(HttpServletRequest req) {
		session = req.getSession(false);
		ModelAndView mav = null;
		if(session != null) {
			List<Product> productList = productService.getAllProducts();
			mav = new ModelAndView("Product");
			mav.addObject(productList);
		}
		else {
			mav = new ModelAndView("Login");
		}
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addProduct")
	public ModelAndView addProduct() {
		return new ModelAndView("AddProduct");
	}

	@ModelAttribute("subCatList")
	public List<SubCategory> getSubCateories(){
		return subCategoryService.getAllSubCategories();
	}

	@ModelAttribute("productList")
	public List<Product> getProductList(){
		return productService.getAllProducts();
	}

	@RequestMapping(method = RequestMethod.POST, value="/saveProduct")
	public ModelAndView saveProduct(HttpServletRequest req, @RequestParam ("imgUpload") MultipartFile file) throws IOException {
		Product product = new Product();
		product.setSubCatID(Integer.parseInt(req.getParameter("selectSubCat")));
		product.setProductName(req.getParameter("productName"));
		Product pro = productService.saveProduct(product);
		
		ModelAndView mav = null;
		boolean flag = false;
		if(pro.getProductName().equals(req.getParameter("productName"))) {
			Image img = saveImage(file, pro.getProductID());
			if(img.getProductID() == pro.getProductID())
				flag = true;
		}
		if(flag)
			mav = new ModelAndView("SuccessRecord");
		else
			mav = new ModelAndView("FailureRecord");
		return mav;
	}

	public Image saveImage(MultipartFile file, int proID) throws IOException {
		Image image = new Image();
		image.setImage(file.getBytes());
		image.setProductID(proID);
		return imageService.saveImage(image);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteProduct")
	public ModelAndView deleteProduct() {
		return new ModelAndView("DeleteProduct");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteProcess")
	public ModelAndView deleteProductProcess(HttpServletRequest req, @RequestParam("id") int id) {
		ModelAndView mav = null;
		HttpSession session = req.getSession();
		if(session != null) {
			if(id != 0) {
				productService.deleteProduct(id);
				imageService.deleteImage(id);
				mav = new ModelAndView("DeleteRecSuccessfully");
			}
		}
		else {
			mav = new ModelAndView("Login");
		}
		return mav;
	}
}
