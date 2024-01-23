package com.sip.ams.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sip.ams.entities.CompteBancaire;

@Controller
public class CompteController {

	static List<CompteBancaire> listecb = new ArrayList<>();

	static {
		CompteBancaire cb1 = new CompteBancaire(1, "Einstein Albert", 12345, LocalDate.of(2024, 1, 10), 111);
		CompteBancaire cb2 = new CompteBancaire(2, "Feynman Richard", 54321, LocalDate.of(2024, 1, 18), 111);
		CompteBancaire cb3 = new CompteBancaire(3, "Bohr Niels", 10000, LocalDate.of(2024, 1, 23), 111);

		listecb.add(cb1);
		listecb.add(cb2);
		listecb.add(cb3);
	}

	@RequestMapping("/comptes")
	public String listeComptes(Model model) {
		model.addAttribute("comptes", listecb);
		return "banque/comptes"; // chemin vers le fichier html
	}

	@GetMapping("/addCompte")
	public String formCompte() {
		return "banque/formCompte.html";
	}

	@PostMapping("/addCompte") // pour les formulaires en mode post
//	@ResponseBody
	public String saveCompte(@RequestParam("numCompte") int numCB, @RequestParam("proprietaire") String ppt,
			@RequestParam("solde") double sol, @RequestParam("dateCreation") LocalDate datCr,
			@RequestParam("idBanque") int idB) {

		CompteBancaire cb = new CompteBancaire(numCB, ppt, sol, datCr, idB);
		listecb.add(cb);
		// return banque.toString();
		return "redirect:comptes"; // ici on met la route de l'action pour faire une redirection
	}

	@GetMapping("/deleteCompte/{numCompte}")
	// @ResponseBody
	public String deleteCompte(@PathVariable("numCompte") int numCompte) {
		CompteBancaire targetCompte = null;
		for (CompteBancaire cb : listecb) {
			if (cb.getNumCompte() == numCompte) {
				targetCompte = cb;
			}
		}
		listecb.remove(targetCompte);
		return "redirect:../comptes";
	}

}
