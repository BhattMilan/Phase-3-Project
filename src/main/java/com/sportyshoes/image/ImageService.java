package com.sportyshoes.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	@Autowired
	ImageRepository imageRepository;
	
	public Image saveImage(Image image) {
		return imageRepository.save(image);
	}

	public void deleteImage(int productID) {
		imageRepository.deleteById(productID);
	}
}
