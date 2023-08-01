package com.rrs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rrs.models.User;
import com.rrs.service.UserService;

/** The Controller Class for Home */
@Controller
public class HomeController {

	/** The User Service */
	@Autowired
	private UserService userService;

	/**
	 * Handles request to get home page
	 *
	 * @return the index page
	 */
	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	/**
	 * Handles request to get the login page
	 *
	 * @return the Login page
	 */
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	/**
	 * Handles request to get the registration page
	 *
	 * @return the registration page
	 */
	@GetMapping("/register")
	public String registrationPage() {
		return "registration";
	}

	/**
	 * Handles request to post new user registration details
	 *
	 * @param user details of the new User
	 * @return Login page with appropriate message if username is unique,
	 *         Registration page with appropriate message if username is not unique
	 */
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user) {
		boolean verified = userService.verifyUniqueUsername(user.getUsername());
		if (verified) {
			userService.registerUser(user);
			return "redirect:/login?registered";
		}
		return "forward:/register?error";
	}

	/**
	 * Handles request to get the forgotPassword page
	 *
	 * @return the forgot password page
	 */
	@GetMapping("/forgotpassword")
	public String getForgotPasswordPage() {
		return "forgotPassword";
	}

	/**
	 * Handles request to post username and security answers for verification
	 *
	 * @param model           the Model object,
	 * @param username        the username,
	 * @param securityAnswer1 answer to first security question,
	 * @param securityAnswer2 answer to second security question,
	 * @param securityAnswer3 answer to third security question
	 * @return Forgot Password page or Reset password page based on verification
	 */
	@PostMapping("/resetpassword")
	public String getResetPasswordPage(Model model, @RequestParam String username, @RequestParam String securityAnswer1,
			@RequestParam String securityAnswer2, @RequestParam String securityAnswer3) {
		boolean verified = userService.verifyUser(username, securityAnswer1, securityAnswer2, securityAnswer3);
		if (!verified) {
			return "redirect:/forgotpassword?error";
		}
		model.addAttribute("username", username);
		return "resetPassword";
	}

	/**
	 * Handles request to post new password
	 *
	 * @param username    the username
	 * @param newPassword the new password
	 * @return the login page with appropriate message
	 */
	@PostMapping("/savepassword")
	public String changePassword(@RequestParam String username, @RequestParam String newPassword) {
		userService.updateUser(username, newPassword);
		return "redirect:/login?passwordreset";
	}

}
