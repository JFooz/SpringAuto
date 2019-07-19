package com.foozcorp.SpringAuto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foozcorp.SpringAuto.models.User;
import com.foozcorp.SpringAuto.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getById(id);
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
		return userService.changerUserData(id, user);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		return userService.deleteUserData(id);
	}

	@GetMapping("/user/{lastname}")
	public User getUserByLastname(@PathVariable String lastname) {
		return userService.getByLastname(lastname);
	}

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

}
