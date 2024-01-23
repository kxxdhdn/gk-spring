package com.sip.ams.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.entities.CompteBancaire;

@Controller
public class CompteController {

	@RequestMapping("/comptes")
	public String listeComptes(Model model) {
		List<CompteBancaire> listecb = new ArrayList<>();

		CompteBancaire cb1 = new CompteBancaire(1, "Einstein Albert", 12345, LocalDate.of(2024, 1, 10), 111);
		CompteBancaire cb2 = new CompteBancaire(2, "Feynman Richard", 54321, LocalDate.of(2024, 1, 18), 111);
		CompteBancaire cb3 = new CompteBancaire(3, "Bohr Niels", 10000, LocalDate.of(2024, 1, 23), 111);

		listecb.add(cb1);
		listecb.add(cb2);
		listecb.add(cb3);

		model.addAttribute("comptes", listecb);
		return "banque/comptes"; // chemin vers le fichier html
	}

}
