package com.sportyshoes.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public User getEmailID(String emailID) {
		return userRepo.findByEmail(emailID);
	}
}
