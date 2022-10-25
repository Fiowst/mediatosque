package com.plb.mediatosque.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.plb.mediatosque.entity.Item;

@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
    ItemRepository itemRepository;
	
	@Test
    public void shouldFindAvailableItems() {
        List<Item> availableItems = itemRepository.findAvailableItems();
        assertEquals("le gras cest la vie", availableItems.get(0).getTitle());
    }
	
	@Test
    public void shouldFindNewItems() {
		LocalDate localdate = LocalDate.of(2022, 10, 1);
        List<Item> newItems = itemRepository.findNewItems(localdate);
        assertEquals("le gras cest la vie", newItems.get(0).getTitle());
    }

	@Test
    public void shouldFindAllDvd() {
        List<Item> dvds = itemRepository.findAllDvd();
        assertEquals("vive les gauffres", dvds.get(0).getTitle());
    }
	
	@Test
    public void shouldFindAllCd() {
        List<Item> cds = itemRepository.findAllCd();
        assertEquals("le gras cest la vie", cds.get(0).getTitle());
    }
	
	@Test
    public void shouldFindAllBooks() {
        List<Item> books = itemRepository.findAllBooks();
        assertEquals("cours de java avancé", books.get(0).getTitle());
    }
	
}
