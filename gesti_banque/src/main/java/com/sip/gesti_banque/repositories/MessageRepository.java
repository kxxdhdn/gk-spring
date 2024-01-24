package com.sip.gesti_banque.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gesti_banque.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer>{

}
