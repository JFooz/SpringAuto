package com.foozcorp.SpringAuto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.foozcorp.SpringAuto.dao.ISeanceCodeDao;
import com.foozcorp.SpringAuto.models.SeanceCode;

//Mets des fucking annotation !!!
@Controller
public class SeanceCodeController {

	@Autowired
	private ISeanceCodeDao seanceCodeDao;

	@GetMapping("/seanceList")
	public String showSeanceList() {
		List<SeanceCode> seanceList = seanceCodeDao.findAll();
		return "seanceList";
	}

	@GetMapping("/seances")
	public String showSignupForm(SeanceCode seanceCode) {
		return "add-seance";
	}

	@PostMapping("/addseance")
	public String addSeance(@Valid SeanceCode seance, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-seance";
		}
		seanceCodeDao.save(seance);
		model.addAttribute("seance", seanceCodeDao.findAll());
		return "index";
	}
}
