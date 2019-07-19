package com.foozcorp.SpringAuto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foozcorp.SpringAuto.dao.IUserDao;
import com.foozcorp.SpringAuto.exception.ResourceNotFoundException;
import com.foozcorp.SpringAuto.models.User;

@Service
public class UserService {

	@Autowired
	private IUserDao userDao;

	public List<User> getAll() {
		return userDao.findAll();
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}

	public User getById(Long id) {
		return userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

	}

	public User changerUserData(Long id, User modifiedUser) {
		return userDao.findById(id).map((user) -> {
			user.setFirstname(modifiedUser.getFirstname());
			user.setLastname(modifiedUser.getLastname());
			user.setBirthDate(modifiedUser.getBirthDate());
			user.setAddress(modifiedUser.getAddress());
			return userDao.save(user);
		}).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}

	public ResponseEntity<?> deleteUserData(Long id) {
		return userDao.findById(id).map((user) -> {
			userDao.delete(user);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

	}

	public User getByLastname(String lastname) {
		return userDao.findByLastname(lastname)
				.orElseThrow(() -> new ResourceNotFoundException("User", "lastname", lastname));

	}
}
