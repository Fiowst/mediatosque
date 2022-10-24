package com.plb.mediatosque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> findItemByCategory(String category) {
		List<Item> items;
		switch (category) {
			case "dvd" :
				items = itemRepository.findAllDvd();
				break;
			case "cd" :
				items = itemRepository.findAllCd();
				break;
			case "book" :
				items = itemRepository.findAllBooks();
				break;
			default :
				items = itemRepository.findAll();
				break;
		}
		return items;
	}
}
