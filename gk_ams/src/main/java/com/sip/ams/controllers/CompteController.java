package com.sip.ams.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sip.ams.entities.CompteBancaire;

@Controller
@RequestMapping("/comptes")
public class CompteController {

	static List<CompteBancaire> listecb = new ArrayList<>();
	static int nbreCB = 0;

	static {
		nbreCB++;
		CompteBancaire cb1 = new CompteBancaire(101000 + nbreCB, "Einstein Albert", 12345, LocalDate.of(2024, 1, 10),
				101);
		nbreCB++;
		CompteBancaire cb2 = new CompteBancaire(101000 + nbreCB, "Feynman Richard", 54321, LocalDate.of(2024, 1, 18),
				101);
		nbreCB++;
		CompteBancaire cb3 = new CompteBancaire(101000 + nbreCB, "Bohr Niels", 10000, LocalDate.of(2024, 1, 23), 101);

		listecb.add(cb1);
		listecb.add(cb2);
		listecb.add(cb3);
	}

	@RequestMapping("/list")
	public String listeComptes(Model model) {
		model.addAttribute("cbs", listecb);
		return "compte/listComptes"; // chemin vers le fichier html
	}

	@GetMapping("/add")
	public String formCompte() {
		return "compte/addCompte.html";
	}

	@PostMapping("/add") // pour les formulaires en mode post
//	@ResponseBody
	public String saveCompte(
//			@RequestParam("numCompte") int numCB,
			@RequestParam("proprietaire") String ppt, @RequestParam("solde") double sol,
			@RequestParam("dateCreation") LocalDate datCr, @RequestParam("idBanque") int idB) {
		nbreCB++;
		CompteBancaire cb = new CompteBancaire(idB * 1000 + nbreCB, // numCB,
				ppt, sol, datCr, idB);
		listecb.add(cb);
		// return cb.toString();
		return "redirect:list"; // ici on met la route de l'action pour faire une redirection
	}

	@GetMapping("/delete/{numCompte}")
	// @ResponseBody
	public String deleteCompte(@PathVariable("numCompte") int numCompte) {
		CompteBancaire targetCompte = null;
		for (CompteBancaire cb : listecb) {
			if (cb.getNumCompte() == numCompte) {
				targetCompte = cb;
			}
		}
		listecb.remove(targetCompte);
		return "redirect:../list";
	}

}
