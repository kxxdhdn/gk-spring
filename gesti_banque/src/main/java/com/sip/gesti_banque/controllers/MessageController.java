package com.sip.gesti_banque.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sip.gesti_banque.entities.Message;
import com.sip.gesti_banque.repositories.MessageRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired // IOC -> Injection de dépendances
	MessageRepository messageRepository;

	@RequestMapping("/save")
	@ResponseBody
	public String saveMessage() {
		// Objet Message en dur
		Message message = new Message();
//		message.setId(1);
		message.setSujet("Test save");
		message.setDescription("C'est un test save. ");
		message.setDatime(LocalDateTime.of(LocalDate.of(2024, 1, 1), LocalTime.of(15, 30)));
		message.setEmail("test.save@gmail.com");

		// Insertion dans la base de données de l'objet message
		Message repos = messageRepository.save(message); // save : insert

		return repos.toString();
	}

	@RequestMapping("/list")
	@ResponseBody
	public String getAllMessages() {
		List<Message> listem = (List<Message>) messageRepository.findAll(); // select *

		return listem.toString();
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String deleteMessage(@PathVariable("id") int id) {
		messageRepository.deleteById(id); // delete
		List<Message> listem = (List<Message>) messageRepository.findAll(); // select *
		
		return listem.toString();
	}

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateMessage(@PathVariable("id") int id) {
		Optional<Message> opMessage = messageRepository.findById(id);
		Message message = opMessage.get();

		message.setId(2);
		message.setSujet("Test update");
		message.setDescription("C'est un test update. ");
		message.setDatime(LocalDateTime.now());
		message.setEmail("test.update@gmail.com");

		// Insertion dans la base de données de l'objet message
		Message repos = messageRepository.save(message); // save : update

		return repos.toString();
	}

}
