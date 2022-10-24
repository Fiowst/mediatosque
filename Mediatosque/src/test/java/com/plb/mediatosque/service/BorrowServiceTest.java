package com.plb.mediatosque.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.plb.mediatosque.MediatosqueApplication;
import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.entity.User;
import com.plb.mediatosque.exception.QuotasExceedException;
import com.plb.mediatosque.exception.UnavailableItemException;
import com.plb.mediatosque.repository.BorrowRepository;
import com.plb.mediatosque.repository.ItemRepository;

@SpringBootTest(classes = MediatosqueApplication.class)
public class BorrowServiceTest {
	
	@Autowired
    BorrowService borrowService;
	
	@Autowired
	BorrowRepository borrowRepository;
	
	@Autowired
	ItemRepository itemRepository;

	@Test
	void testBorrowItem() throws QuotasExceedException, UnavailableItemException {
		// créer un utilisateur pour le test
		User newUser = new User();
        newUser.setId(1L);
        
        // enregistrer le nombre de document emprunté pour cet utilisateur avant le test
        int nbrOfItemBorrowedByUserBefore = borrowRepository.findByUser_Id(newUser.getId()).size();

        // créer un document pour le test
        Item newItem = new Item();
        newItem.setId(1L);

        // exécution du test
        borrowService.borrowItem(newItem.getId(), newUser);
        
        // enregistrer le nombre de document emprunté pour cet utilisateur après le test
        int nbrOfItemBorrowedByUserAfter = borrowRepository.findByUser_Id(newUser.getId()).size();
        
        // vérifier qu'il y a bien un emprunt de plus pour cet utilisateur
        assertEquals(nbrOfItemBorrowedByUserBefore + 1,nbrOfItemBorrowedByUserAfter);
	}

}
