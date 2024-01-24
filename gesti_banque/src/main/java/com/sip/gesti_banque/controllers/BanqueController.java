package com.sip.gesti_banque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sip.gesti_banque.entities.Banque;
import com.sip.gesti_banque.repositories.BanqueRepository;

@Controller
@RequestMapping("/banques")
public class BanqueController {

	@Autowired // IOC -> Injection de dépendances
	BanqueRepository banqueRepository;

	@RequestMapping("/save")
	@ResponseBody
	public String saveBanque() {
		// Objet banque en dur
		Banque banque = new Banque();
//		banque.setIdBanque(101);
		banque.setNomBanque("BNP");
		banque.setAdresseBanque("Paris, France");
		banque.setCapitalBanque(300000);

		// Insertion dans la base de données de l'objet banque
		Banque repos = banqueRepository.save(banque); // save : insert

		return repos.toString();
	}

	@RequestMapping("/list")
	@ResponseBody
	public String getAllBanques() {
		List<Banque> listeb = (List<Banque>) banqueRepository.findAll(); // select *

		return listeb.toString();
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String deleteBanque(@PathVariable("id") int id) {
		banqueRepository.deleteById(id); // delete
		List<Banque> listeb = (List<Banque>) banqueRepository.findAll(); // select *
		
		return listeb.toString();
	}

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateBanque(@PathVariable("id") int id) {
		Optional<Banque> opBanque = banqueRepository.findById(id);
		Banque banque = opBanque.get();

		banque.setIdBanque(id);
		banque.setNomBanque("Revolut");
		banque.setAdresseBanque("Londres, UK");
		banque.setCapitalBanque(666666);

		// Insertion dans la base de données de l'objet banque
		Banque repos = banqueRepository.save(banque); // save : update

		return repos.toString();
	}

}
