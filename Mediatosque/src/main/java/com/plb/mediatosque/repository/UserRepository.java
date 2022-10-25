package com.plb.mediatosque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.mediatosque.entity.User;


public interface UserRepository extends JpaRepository <User, Long> {

	// récupérer un utilisateur par son login (email)
	User findByLogin(String	login);
	
}
