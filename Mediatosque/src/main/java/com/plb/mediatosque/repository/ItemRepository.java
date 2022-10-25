package com.plb.mediatosque.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.plb.mediatosque.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	// Retrouver les items disponibles
    @Query("SELECT i FROM Item i WHERE i.quantity > 0")
    List<Item> findAvailableItems();

 

    // retrouver les nouveaux items
    @Query("SELECT i FROM Item i WHERE i.releaseDate >= :newItemDate")
    List<Item> findNewItems(@Param("newItemDate") LocalDate newItemDate);

 

    // retrouver les dvd
    @Query("From DVD")
    List<Item> findAllDvd();

 

    // retrouver les cd
    @Query("From CD")
    List<Item> findAllCd();

 

    // retrouver les livres
    @Query("From Book")
    List<Item> findAllBooks();
	
}
