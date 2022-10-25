package com.plb.mediatosque.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

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
@Transactional
public class BorrowService {
	
	@Autowired
	BorrowRepository borrowRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Borrow borrowItems(Long user_id, List<Item> items) throws QuotasExceedException, UnavailableItemException {
		// vérifier que l'utilisateur n'a pas dépassé le nombre d'emprunt (max 3)
		// récupérer les emprunts de l'utilisateur
		List<Borrow> userBorrows = borrowRepository.findByUser_Id(user_id);
		
		int nbrOfBorrowedItems = 0;
		for(Borrow userBorrow : userBorrows) {
			if(userBorrow.getReturnDate() == null) {
				nbrOfBorrowedItems += userBorrow.getItems().size();
			}
		}
		
		// si l'utilisateur a déjà 3 emprunts, on renvoie l'exception
		if(nbrOfBorrowedItems > 2) {
			throw new QuotasExceedException("Vous avez déjà 3 documents empruntés. Merci d'en restituer un pour pouvoir emprunter un nouveau document.");
		}
		
		Set<Item> itemToAdd = new HashSet<>();
		
		// vérifier qu'il reste des copies des items
		for(Item item : items) {
			Item selectedItemToBorrow = itemRepository.findById(item.getId()).orElseThrow(() -> new EntityNotFoundException());
			if(selectedItemToBorrow.getQuantity() < 1) {
				throw new UnavailableItemException("Le document " + selectedItemToBorrow.getTitle() + " n'est pas disponible actuellement.");
			} else {				
				// s'il reste une copie, on décrémente l'item
				selectedItemToBorrow.setQuantity(selectedItemToBorrow.getQuantity() - 1);
				itemToAdd.add(selectedItemToBorrow);
				itemRepository.save(selectedItemToBorrow);
			}
		}
		
		// récupérer l'utilisateur à l'origine de l'emprunt
		User user = userRepository.findById(user_id).orElseThrow(() -> new EntityNotFoundException());
		
		// ajouter l'emprunt
		Borrow addThisBorrow = new Borrow();
		addThisBorrow.setBorrowDate(LocalDate.now());
		addThisBorrow.setUser(user);
		addThisBorrow.setItems(itemToAdd);
		borrowRepository.save(addThisBorrow);
		return addThisBorrow;
	}
	
	public void returnBorrow(Long user_id, Long borrow_id) {
		// récupérer l'emprunt lié à l'id
		Borrow getBorrow = borrowRepository.findById(borrow_id).orElseThrow(() -> new EntityNotFoundException());
		
		// incrémenter les items retournés
		Set<Item> getItemFromBorrow = getBorrow.getItems();
		for(Item selectedItemToReturn : getItemFromBorrow) {
			selectedItemToReturn.setQuantity(selectedItemToReturn.getQuantity() + 1);
			itemRepository.save(selectedItemToReturn);
		}
		getBorrow.setReturnDate(LocalDate.now());
		borrowRepository.save(getBorrow);
	}
	
}
