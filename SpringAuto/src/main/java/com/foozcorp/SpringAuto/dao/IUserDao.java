package com.foozcorp.SpringAuto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foozcorp.SpringAuto.models.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {

}
