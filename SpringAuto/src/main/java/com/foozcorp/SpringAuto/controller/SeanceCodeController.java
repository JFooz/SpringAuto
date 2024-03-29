package com.foozcorp.SpringAuto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foozcorp.SpringAuto.models.SeanceCode;
import com.foozcorp.SpringAuto.service.SeanceCodeService;

//Mets des fucking annotation !!!
@RestController
@RequestMapping("/api")
public class SeanceCodeController {

	@Autowired
	private SeanceCodeService seanceCode;

	@GetMapping("/seance-code")
	public List<SeanceCode> getAllSeance() {
		return seanceCode.getAllSeance();
	}

	@GetMapping("/seance-code/{id}")
	public SeanceCode getOneSeance(@PathVariable Long id) {
		return seanceCode.getById(id);
	}

	@PostMapping("/seance-code")
	public SeanceCode addSeanceCode(@Valid @RequestBody SeanceCode seance) {
		return seanceCode.saveSeanceCode(seance);
	}

	@PostMapping("/{userId}/seance-code/{id}")
	public SeanceCode signInStudent(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {

		return seanceCode.addStudentInSeance(userId, id);
	}

//	@GetMapping("/seanceList")
//	public String showSeanceList() {
//		List<SeanceCode> seanceList = seanceCodeDao.findAll();
//		return "seanceList";
//	}
//
//	@GetMapping("/seances")
//	public String showSignupForm(SeanceCode seanceCode) {
//		return "add-seance";
//	}
//
//	@PostMapping("/addseance")
//	public String addSeance(@Valid SeanceCode seance, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			return "add-seance";
//		}
//		seanceCodeDao.save(seance);
//		model.addAttribute("seance", seanceCodeDao.findAll());
//		return "index";
//	}
}
