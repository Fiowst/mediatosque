package com.plb.mediatosque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.mediatosque.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	// Retrouver les items disponibles
	
}
