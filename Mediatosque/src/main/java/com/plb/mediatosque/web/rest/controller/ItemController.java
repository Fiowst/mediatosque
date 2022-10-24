package com.plb.mediatosque.web.rest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.repository.ItemRepository;
import com.plb.mediatosque.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemService itemService;
	
	// lister tous les documents
	@GetMapping
	public ResponseEntity<List<Item>> findAll(){
		return ResponseEntity.ok(itemRepository.findAll());
	}
	
	// lister les documents disponibles
	@GetMapping("/available")
	public ResponseEntity<List<Item>> findAvailableItems() {
		return ResponseEntity.ok(itemRepository.findAvailableItems());
	}
	
	// lister les nouveaux documents
	@GetMapping("/new")
	public ResponseEntity<List<Item>> findNewItems() {
		return ResponseEntity.ok(itemRepository.findNewItems(LocalDate.now().minusMonths(1)));
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Item>> findItemByCategory(String category) {
		return ResponseEntity.ok(itemService.findItemByCategory(category.toLowerCase()));
	}
}
