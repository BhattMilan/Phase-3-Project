package com.sportyshoes.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.product.Product;
import com.sportyshoes.user.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(method=RequestMethod.GET, value= {"/"})
	public ModelAndView login() {
		return new ModelAndView("Login");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/loginProcess")
	public ModelAndView loginProcess(HttpServletRequest req) {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		ModelAndView mav = null;
		if(email != null && email.equals(userService.getEmailID(email).getEmail()) &&
				pass != null && pass.equals(userService.getEmailID(email).getPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("email", email);
				mav = new ModelAndView("Dashboard");
		}
		else {
			mav = new ModelAndView("LoginFailed");
		}
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		ModelAndView mav = null;
		if(session != null) {
			session.removeAttribute("email");
			session.invalidate();
			res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			mav = new ModelAndView("Login");
		}
		else {
			mav = new ModelAndView("Login");
		}
		return mav;
	}
}
