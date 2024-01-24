package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sip.ams.entities.Banque;

@Controller // Annotation pour rendre la classe comme un controlleur
@RequestMapping("/banques")
public class BanqueController { // un controlleur

	static List<Banque> listeb = new ArrayList<>();
	static int nbreBanque = 100;

	// bloc static s'exécute lors de l'invocation de la classe BanqueController
	static {
		nbreBanque++;
		Banque b1 = new Banque(nbreBanque, "BNP", "Paris, France", 300000);
		nbreBanque++;
		Banque b2 = new Banque(nbreBanque, "SG", "Nantes, France", 100000);
		nbreBanque++;
		Banque b3 = new Banque(nbreBanque, "LCL", "Lyon, France", 200000);

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

	@RequestMapping("../details")
	// @ResponseBody
	public String detailsBanque(Model model) {
		Banque banque = new Banque(0, "Boursorama", "Bordeaux, France", 100000);
//		return "<h3 align=center>"+banque.toString()+"</h3>";

		String centre = "Global Knowledge";
		model.addAttribute("centreJava", centre);
		String formateur = "Mohamed Amine MEZGHICH";
		model.addAttribute("trainer", formateur);
		model.addAttribute("banque", banque);

		return "banque/detailsBanque"; // cette action retourne une View situé sous templates/banque/detailsBanque.html
	}

	@RequestMapping("../stagiaires")
	public String listeStagiaires(Model model) {
		String noms[] = { "Fatima", "Teddy", "Jocelyn", "Ahmed", "Anne", "Afef", "Benoît", "Pierre", "Abdelleh",
				"Ismail", "Ibtissem", "Rahma", "Ayda", "Hu", "Andrei" };
		model.addAttribute("noms", noms);
		return "banque/stagiaires"; // chemin vers le fichier html
	}

	@RequestMapping("/list")
	public String listeBanques(Model model) {
		model.addAttribute("banques", listeb);
		return "banque/listBanques"; // chemin vers le fichier html
	}

	@GetMapping("/add")
	public String formBanque() {
		return "banque/addBanque.html";
	}

	@PostMapping("/add") // pour les formulaires en mode post
//	@ResponseBody
	public String saveBanque(
//			@RequestParam("idBanque") int idB,
			@RequestParam("nomBanque") String nomB, @RequestParam("adresseBanque") String adrB,
			@RequestParam("capitalBanque") double capB) {

//		 return "banque/addBanque.html";
//		return nomB + " - " + adrB + " - " + capB;
		nbreBanque++;
		Banque banque = new Banque(nbreBanque, //idB,
				nomB, adrB, capB);
		listeb.add(banque);
		// return banque.toString();
		return "redirect:list"; // ici on met la route de l'action pour faire une redirection
	}

	@GetMapping("/delete/{idBanque}")
	// @ResponseBody
	public String deleteBanque(@PathVariable("idBanque") int idBanque) {
		Banque targetBanque = null;
		for (Banque banque : listeb) {
//			if (banque.getNomBanque().equals(nomBanque)) {
			if (banque.getIdBanque() == idBanque) {
				targetBanque = banque;
			}
		}
		listeb.remove(targetBanque);
		return "redirect:../list";
	}

}
