package com.sip.ams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Annotation pour rendre la classe comme un controlleur
public class BanqueController { // un controlleur

	@RequestMapping("/welcome")
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
//		Banque banque = new Banque("Boursorama", 100000, "Paris, France");
//		return "<h3 align=center>"+banque.toString()+"</h3>";

		String centre = "Global Knowledge";
		model.addAttribute("centreJava", centre);
		
		String formateur = "Mohamed Amine MEZGHICH";
		model.addAttribute("trainer", formateur);

		return "banque/detailsBanque"; // cette action retourne une View situé sous templates/banque/detailsBanque.html
	}

}
