package com.sportyshoes.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.image.ImageRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public byte[] getImage(int productID) {
		return imageRepository.findById(productID).get().getImage();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(int productID) {
		productRepository.deleteById(productID);
	}
}
