package com.foozcorp.SpringAuto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foozcorp.SpringAuto.dao.IUserDao;
import com.foozcorp.SpringAuto.models.User;

@RestController
@RequestMapping("/api")
public class AccueilController {

	@Autowired
	private IUserDao userDao;

//	@GetMapping("/accueil")
//	public String showAccueil() {
//
//		List<User> userList = userDao.findAll();
//		return "index";
//	}
//
//	@GetMapping("/sign-up")
//	public String showSignupForm(User user) {
//		return "add-user";
//	}
//
//	@PostMapping("/adduser")
//	public String addUser(@Valid User user, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			return "add-user";
//		}
//		userDao.save(user);
//		model.addAttribute("user", userDao.findAll());
//		return "index";
//	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) {
		return userDao.save(user);
	}
}
