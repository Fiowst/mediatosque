package com.plb.mediatosque.web.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.mediatosque.entity.Borrow;
import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.exception.QuotasExceedException;
import com.plb.mediatosque.exception.UnavailableItemException;
import com.plb.mediatosque.service.BorrowService;

@RestController
@RequestMapping("/api")
public class BorrowController {
	
	@Autowired
	BorrowService borrowService;
	
	@PostMapping("/user/{user_id}/borrow/{item}")
	public ResponseEntity<Borrow> borrowItem(@Valid @PathVariable Long user_id, @RequestBody List<Item> items) throws QuotasExceedException, UnavailableItemException {
		return ResponseEntity.status(HttpStatus.CREATED).body(borrowService.borrowItem(user_id, items));
	}
	
	@PutMapping("/user/{user_id}/return/{borrow_id}")
	public ResponseEntity<Void> returnItem(@PathVariable Long user_id, @PathVariable Long borrow_id) {
		borrowService.returnItem(user_id, borrow_id);
		return ResponseEntity.ok().build();
	}
}
