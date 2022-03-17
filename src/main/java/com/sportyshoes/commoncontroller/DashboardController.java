package com.sportyshoes.commoncontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.user.UserService;

@RestController
public class DashboardController {

	@Autowired
	UserService userService;
	
//	@RequestMapping({"/dashboard"})
//	public ModelAndView dashboard(HttpServletRequest req, HttpServletResponse res) {
//		String email = req.getParameter("email");
//		String pass = req.getParameter("pass");
//		ModelAndView mav = null;
//
//		if(email != null && email.equals(userService.getEmailID(email).getEmail()) &&
//				pass != null && pass.equals(userService.getEmailID(email).getPassword())) {
//				mav = new ModelAndView("Dashboard");
//				HttpSession session = req.getSession();
//				session.setAttribute("email", email);
//		}
//		else {
//			mav = new ModelAndView("LoginFailed");
//		}
//		return mav;
//	}
}
