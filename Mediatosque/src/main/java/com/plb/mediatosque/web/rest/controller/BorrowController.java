package com.plb.mediatosque.web.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.mediatosque.entity.Borrow;
import com.plb.mediatosque.repository.BorrowRepository;
import com.plb.mediatosque.service.BorrowService;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
	
	private final BorrowRepository borrowRepository;
	private final BorrowService borrowService;

	public BorrowController(BorrowRepository borrowRepository, BorrowService borrowService) {
		this.borrowRepository = borrowRepository;
		this.borrowService = borrowService;
	}
	
	@GetMapping
	public ResponseEntity<List<Borrow>> getAll() {
		List<Borrow> allBorrows = borrowRepository.findAll();
		
		if (allBorrows.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allBorrows);
        }
	}
	
	@GetMapping("/borrow/user/{id}")
    public ResponseEntity<List<Borrow>> getByUser(@PathVariable Long id){
		List<Borrow> borrowByUserId = borrowService.getByUserId(id);
		if (borrowByUserId.isEmpty()) {
          return ResponseEntity.notFound().build();
      } else {
          return ResponseEntity.ok(borrowByUserId);
      }
    }
	
}
