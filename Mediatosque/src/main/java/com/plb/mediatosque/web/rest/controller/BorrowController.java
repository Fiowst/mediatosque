package com.plb.mediatosque.web.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.plb.mediatosque.entity.Borrow;
import com.plb.mediatosque.entity.User;
import com.plb.mediatosque.exception.QuotasExceedException;
import com.plb.mediatosque.exception.UnavailableItemException;
import com.plb.mediatosque.repository.BorrowRepository;
import com.plb.mediatosque.service.BorrowService;

@RestController
@RequestMapping("/api")
public class BorrowController {
	
	@Autowired
	BorrowService borrowService;
	
	@Autowired
	BorrowRepository borrowRepository;
	
	@PostMapping("/borrow/{item_id}")
	public ResponseEntity<Borrow> borrowItem(@Valid @PathVariable Long item_id, @RequestBody User user) throws QuotasExceedException, UnavailableItemException {
		return ResponseEntity.ok(borrowService.borrowItem(item_id, user));
	}
	
	@DeleteMapping("/delete/borrow/{borrow_id}")
	public ResponseEntity<Void> returnItem(@PathVariable Long id) {
		try {
			borrowRepository.deleteById(id);
			return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with id : " + id);
        }
	}
}
