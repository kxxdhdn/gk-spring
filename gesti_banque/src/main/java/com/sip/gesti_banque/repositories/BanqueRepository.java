package com.sip.gesti_banque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gesti_banque.entities.Banque;

@Repository
public interface BanqueRepository extends CrudRepository<Banque, Integer>{
	
	// Ici, on hérite implicitement les 10 méthodes du crudRepository.
	// On peut également ajouter/enricher ce repo par d'autres méthodes.

}
