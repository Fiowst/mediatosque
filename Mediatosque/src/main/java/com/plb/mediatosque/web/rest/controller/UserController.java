package com.plb.mediatosque.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.mediatosque.entity.Borrow;
import com.plb.mediatosque.repository.BorrowRepository;
import com.plb.mediatosque.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	BorrowRepository borrowRepository;
	
	@Autowired
	UserService userService;
	
	// visualiser les emprunts d'un utilisateur
	@GetMapping("/users/{id}/borrows")
    public ResponseEntity<List<Borrow>> getByUserId(@PathVariable Long id){
		return ResponseEntity.ok(borrowRepository.findByUser_Id(id));
    }
	
}
