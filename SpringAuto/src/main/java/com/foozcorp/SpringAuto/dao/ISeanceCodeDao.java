package com.foozcorp.SpringAuto.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foozcorp.SpringAuto.models.SeanceCode;

@Repository
public interface ISeanceCodeDao extends JpaRepository<SeanceCode, Long> {

	public Optional<SeanceCode> findAllSeanceCode(String lieu);
}
