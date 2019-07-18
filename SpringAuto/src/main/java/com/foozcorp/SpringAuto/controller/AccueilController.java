package com.foozcorp.SpringAuto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.foozcorp.SpringAuto.dao.IUserDao;
import com.foozcorp.SpringAuto.models.User;

@Controller
public class AccueilController {

	@Autowired
	private IUserDao userDao;

	@GetMapping("/accueil")
	public String showAccueil() {

		List<User> useList = userDao.findAll();
		return "index";
	}

	@PostMapping("/signup")
	public String showSignupForm() {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}
		userDao.save(user);
		model.addAttribute("user", userDao.findAll());
		return "index";
	}
}
