package com.foozcorp.SpringAuto.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foozcorp.SpringAuto.models.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {

	public Optional<User> findByLastname(String lastname);
}
