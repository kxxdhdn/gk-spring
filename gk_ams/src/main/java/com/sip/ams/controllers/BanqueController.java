package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sip.ams.entities.Banque;

@Controller // Annotation pour rendre la classe comme un controlleur
public class BanqueController { // un controlleur

	static List<Banque> listeb = new ArrayList<>();

	// bloc static s'exécute lors de l'invocation de la classe BanqueController
	static {
		Banque b1 = new Banque("SG", "Lyon, France", 200000);
		Banque b2 = new Banque("LCL", "Nantes, France", 100000);
		Banque b3 = new Banque("BNP", "Paris, France", 300000);

		listeb.add(b1);
		listeb.add(b2);
		listeb.add(b3);
	}

	@RequestMapping("/hello")
	@ResponseBody // retourner le résultat entre les "" sur le navigateur
	public String welcome() { // une action
//		System.out.println("Welcome GK sur la console");
		return "Welcome GK";
	}

	@RequestMapping("/info")
	@ResponseBody
	public String info() {
		return "<h2 align=center>Une formation Spring à GK</h2>";
	}

	@RequestMapping("/details")
	// @ResponseBody
	public String detailsBanque(Model model) {
		Banque banque = new Banque("Boursorama", "Bordeaux, France", 100000);
//		return "<h3 align=center>"+banque.toString()+"</h3>";

		String centre = "Global Knowledge";
		model.addAttribute("centreJava", centre);
		String formateur = "Mohamed Amine MEZGHICH";
		model.addAttribute("trainer", formateur);
		model.addAttribute("banque", banque);

		return "banque/detailsBanque"; // cette action retourne une View situé sous templates/banque/detailsBanque.html
	}

	@RequestMapping("/stagiaires")
	public String listeStagiaires(Model model) {
		String noms[] = { "Fatima", "Teddy", "Jocelyn", "Ahmed", "Anne", "Afef", "Benoît", "Pierre", "Abdelleh",
				"Ismail", "Ibtissem", "Rahma", "Ayda", "Hu", "Andrei" };
		model.addAttribute("noms", noms);
		return "banque/stagiaires"; // chemin vers le fichier html
	}

	@RequestMapping("/banques")
	public String listeBanques(Model model) {
		model.addAttribute("banques", listeb);
		return "banque/banques"; // chemin vers le fichier html
	}

	@GetMapping("/addBanque")
	public String formBanque() {
		return "banque/formBanque.html";
	}

	@PostMapping("/addBanque") // pour les formulaires en mode post
//	@ResponseBody
	public String saveBanque(@RequestParam("nomBanque") String nomB, @RequestParam("adresseBanque") String adrB,
			@RequestParam("capitalBanque") double capB) {

//		 return "banque/formBanque.html";
//		return nomB + " - " + adrB + " - " + capB;
		Banque banque = new Banque(nomB, adrB, capB);
		listeb.add(banque);
		// return banque.toString();
		return "redirect:banques"; // ici on met la route de l'action pour faire une redirection
	}

	@GetMapping("/deleteBanque/{nomBanque}")
	// @ResponseBody
	public String deleteBanque(@PathVariable("nomBanque") String nomBanque) {
		Banque targetBanque = null;
		for (Banque banque : listeb) {
			if (banque.getNomBanque().equals(nomBanque)) {
				targetBanque = banque;
			}
		}
		listeb.remove(targetBanque);
		return "redirect:../banques";
	}

}
