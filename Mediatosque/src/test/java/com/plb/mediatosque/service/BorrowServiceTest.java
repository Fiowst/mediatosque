package com.plb.mediatosque.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.plb.mediatosque.MediatosqueApplication;
import com.plb.mediatosque.entity.Borrow;
import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.entity.User;
import com.plb.mediatosque.exception.QuotasExceedException;
import com.plb.mediatosque.exception.UnavailableItemException;
import com.plb.mediatosque.repository.BorrowRepository;

@SpringBootTest(classes = MediatosqueApplication.class)
@Transactional
public class BorrowServiceTest {
	
	@Autowired
    BorrowRepository borrowRepository;
	
	@Autowired
    BorrowService borrowService;

	@Test
	void testBorrowItem() throws QuotasExceedException, UnavailableItemException {
		// créer un utilisateur pour le test
		User newUser = new User();
        newUser.setId(1L);
        
        
        // récupérer la liste des emprunts de cet utilisateur
        List<Borrow> newUserBorrowsBefore = borrowRepository.findByUser_Id(newUser.getId());
        // enregistrer le nombre de document emprunté pour cet utilisateur avant le test
        int nbrOfItemBorrowedByUserBefore = 0;
        for(Borrow newUserBorrow : newUserBorrowsBefore) {
        	if(newUserBorrow.getReturnDate() == null) {
        		nbrOfItemBorrowedByUserBefore += newUserBorrow.getItems().size();
			}
        }

        // créer un document pour le test
        List<Item> newItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId(1L);
        Item item2 = new Item();
        item2.setId(2L);
        newItems.add(item1);
        newItems.add(item2);

        // exécution du test
        borrowService.borrowItems(newUser.getId(), newItems);
        
        // récupérer la liste des emprunts de cet utilisateur
        List<Borrow> newUserBorrowsAfter = borrowRepository.findByUser_Id(newUser.getId());
        // enregistrer le nombre de document emprunté pour cet utilisateur après le test
        int nbrOfItemBorrowedByUserAfter = 0;
        for(Borrow newUserBorrow : newUserBorrowsAfter) {
        	if(newUserBorrow.getReturnDate() == null) {
        		nbrOfItemBorrowedByUserAfter += newUserBorrow.getItems().size();
			}
        }
        
        // vérifier qu'il y a bien un emprunt de plus pour cet utilisateur
        assertEquals(nbrOfItemBorrowedByUserBefore + 2,nbrOfItemBorrowedByUserAfter);
	}
	
	@Test
	void testUpdateBorrow() throws QuotasExceedException, UnavailableItemException {
		// créer un utilisateur pour le test
		User newUser = new User();
        newUser.setId(1L);

        // créer un document pour le test
        List<Item> newItems = new ArrayList<>();
        Item item1 = new Item();
        item1.setId(1L);
        Item item2 = new Item();
        item2.setId(2L);
        newItems.add(item1);
        newItems.add(item2);

        // réaliser un emprunt
        Borrow newBorrow = borrowService.borrowItems(newUser.getId(), newItems);
        
        // exécution du test
        borrowService.returnBorrow(newUser.getId(), newBorrow.getId());
        
        Borrow borrowAfterUpdate = borrowRepository.findById(newBorrow.getId()).get();
        LocalDate returnDate = borrowAfterUpdate.getReturnDate();
        
        // vérifier qu'il y a bien une date de retour pour l'emprunt test de cet utilisateur
        assertTrue(returnDate != null);
	}

}
