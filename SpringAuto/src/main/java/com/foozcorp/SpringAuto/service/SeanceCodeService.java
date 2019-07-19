package com.foozcorp.SpringAuto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foozcorp.SpringAuto.dao.ISeanceCodeDao;
import com.foozcorp.SpringAuto.dao.IUserDao;
import com.foozcorp.SpringAuto.exception.ResourceNotFoundException;
import com.foozcorp.SpringAuto.models.SeanceCode;

@Service
public class SeanceCodeService {

	@Autowired
	private ISeanceCodeDao seanceCodeDao;

	@Autowired
	private IUserDao userDao;

	// Ajouté dans le controller
	public List<SeanceCode> getAllSeance() {
		return seanceCodeDao.findAll();
	}

	public SeanceCode saveSeanceCode(SeanceCode seanceCode) {
		return seanceCodeDao.save(seanceCode);
	}

	// Ajouter dans le controller
	public SeanceCode getById(Long id) {
		return seanceCodeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("SeanceCode", "id", id));

	}

	public SeanceCode changerSeanceCodeData(Long id, SeanceCode modifiedSeanceCode) {
		return seanceCodeDao.findById(id).map((seanceCode) -> {
			seanceCode.setLieu(modifiedSeanceCode.getLieu());
			seanceCode.setNbrPlace(modifiedSeanceCode.getNbrPlace());
			seanceCode.setNom(modifiedSeanceCode.getNom());
			return seanceCodeDao.save(seanceCode);
		}).orElseThrow(() -> new ResourceNotFoundException("SeanceCode", "id", id));
	}

	public ResponseEntity<?> deleteSeanceCodeData(Long id) {
		return seanceCodeDao.findById(id).map((seanceCode) -> {
			seanceCodeDao.delete(seanceCode);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("SeanceCode", "id", id));

	}

	public SeanceCode findAllByLieu(String lieu) {
		return seanceCodeDao.findAllByLieu(lieu)
				.orElseThrow(() -> new ResourceNotFoundException("SeanceCode", "lieu", lieu));
	}

	public SeanceCode addStudentInSeance(Long userId, Long seanceId) {
		return userDao.findById(userId).map((user) -> {
			return seanceCodeDao.findById(seanceId).map((seance) -> {
				seance.getUserList().add(user);
				return seanceCodeDao.save(seance);
			}).orElseThrow(() -> new ResourceNotFoundException("seance", "id", seanceId));
		}).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
	}
}
