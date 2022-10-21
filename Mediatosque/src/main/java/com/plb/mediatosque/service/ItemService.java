package com.plb.mediatosque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.repository.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository=itemRepository;
	}
	
	public List<Item> getAll(){
		List<Item> allItem = itemRepository.findAll();
		return allItem;
	}
}
