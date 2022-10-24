package com.plb.mediatosque.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plb.mediatosque.entity.Borrow;
import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.entity.User;
import com.plb.mediatosque.exception.QuotasExceedException;
import com.plb.mediatosque.exception.UnavailableItemException;
import com.plb.mediatosque.repository.BorrowRepository;
import com.plb.mediatosque.repository.ItemRepository;
import com.plb.mediatosque.repository.UserRepository;

@Service
public class BorrowService {
	
	@Autowired
	BorrowRepository borrowRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Borrow borrowItem(Long item_id, User user) throws QuotasExceedException, UnavailableItemException {
		// vérifier que l'utilisateur n'a pas dépassé le nombre d'emprunt (max 3)
		// on récupère les emprunts de l'utilisateur
		int nbrOfBorrowedItems = borrowRepository.findByUser_Id(user.getId()).size();
		
		// si l'utilisateur a déjà 3 emprunts, on renvoie l'exception
		if(nbrOfBorrowedItems > 2) {
			throw new QuotasExceedException("Vous avez déjà 3 documents empruntés. Merci d'en restituer un pour pouvoir emprunter un nouveau document.");
		}
		
		Set<Item> itemToAdd = new HashSet<>();
		
		// vérifier qu'il reste des copies des items
		Item selectedItemToBorrow = itemRepository.findById(item_id).orElseThrow(() -> new EntityNotFoundException());
		if(selectedItemToBorrow.getQuantity() < 1) {
			throw new UnavailableItemException("Le document " + selectedItemToBorrow.getTitle() + " n'est pas disponible actuellement.");
		} else {				
			// s'il reste une copie, on décrémente l'item
			selectedItemToBorrow.setQuantity(selectedItemToBorrow.getQuantity() - 1);
			itemToAdd.add(selectedItemToBorrow);
		}
		
		// ajouter l'emprunt
		Borrow addThisBorrow = new Borrow();
		addThisBorrow.setBorrowDate(LocalDate.now());
		addThisBorrow.setReturnDate(LocalDate.now().plusDays(7));
		addThisBorrow.setUser(user);
		addThisBorrow.setItems(itemToAdd);
		borrowRepository.save(addThisBorrow);
		return addThisBorrow;
	}
	
	public Item returnItem(Long borrow_id) {
		// récupérer l'emprunt lié à l'id
		Borrow getBorrow = borrowRepository.findById(borrow_id).orElseThrow(() -> new EntityNotFoundException());
		
		// incrémenter l'item retourné
		Set<Item> getItemFromBorrow = getBorrow.getItems();
		Item selectedItemToReturn = getItemFromBorrow.stream().findFirst().orElseThrow(() -> new EntityNotFoundException());
		selectedItemToReturn.setQuantity(selectedItemToReturn.getQuantity() + 1);
		itemRepository.save(selectedItemToReturn);
		
		// supprimer l'emprunt
		borrowRepository.deleteById(borrow_id);
		
		return selectedItemToReturn;
	}
	
}
