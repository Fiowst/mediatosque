package com.plb.mediatosque.web.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.repository.ItemRepository;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	private final ItemRepository itemRepository;
	
	public ItemController(ItemRepository itemRepository) {
		this.itemRepository=itemRepository;
	}
	
	@GetMapping
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
}
