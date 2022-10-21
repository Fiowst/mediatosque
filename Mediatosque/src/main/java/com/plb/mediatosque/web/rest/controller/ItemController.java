package com.plb.mediatosque.web.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.service.ItemService;

@RestController
@RequestMapping("api/items")
public class ItemController {
	
	private final ItemService itemService;
	
	public ItemController(ItemService itemService) {
		this.itemService=itemService;
	}
	
	@GetMapping
	public ResponseEntity<List<Item>> getAll(){
		List<Item> allItems=itemService.getAll();
		
		if (allItems.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(allItems);
		}
	}
}
