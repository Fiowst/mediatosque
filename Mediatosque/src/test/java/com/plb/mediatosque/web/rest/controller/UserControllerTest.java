package com.plb.mediatosque.web.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.plb.mediatosque.MediatosqueApplication;
import com.plb.mediatosque.entity.Borrow;
import com.plb.mediatosque.entity.Item;
import com.plb.mediatosque.entity.User;
import com.plb.mediatosque.repository.BorrowRepository;
import com.plb.mediatosque.repository.ItemRepository;
import com.plb.mediatosque.repository.UserRepository;

@SpringBootTest(classes = MediatosqueApplication.class)
public class UserControllerTest {
	
    public static final String DEFAULT_LOGIN = "login";
    public static final String DEFAULT_PASSWORD = "password";
    public static final String DEFAULT_LASTNAME = "lastname";
    public static final String DEFAULT_FIRSTNAME = "firstname";
    
    public static final String DEFAULT_TITLE = "title";
    public static final int DEFAULT_QUANTITY = 3;
    public static final LocalDate DEFAULT_RELEASE_DATE = LocalDate.now();
    public static final String DEFAULT_AUTHOR = "author";
    
    public static final LocalDate DEFAULT_BORROW_DATE = LocalDate.now();
    public static final LocalDate DEFAULT_RETURN_DATE = LocalDate.now().plusDays(7);
    
    private User user;
    private Item item;
    private Borrow borrow;
	
	@Autowired
	BorrowRepository borrowRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	public static User createUserEntity() {
		User user = new User();
		user.setLogin(DEFAULT_LOGIN);
		user.setPassword(DEFAULT_PASSWORD);
		user.setLastName(DEFAULT_LASTNAME);
		user.setFirstName(DEFAULT_FIRSTNAME);
        return user;
    }

    public static Item createItemEntity() {
    	Item item = new Item();
    	item.setTitle(DEFAULT_TITLE);
    	item.setQuantity(DEFAULT_QUANTITY);
    	item.setReleaseDate(DEFAULT_RELEASE_DATE);
    	item.setAuthor(DEFAULT_AUTHOR);
        return item;
    }
    
    public static Borrow createBorrowEntity() {
    	Borrow borrow = new Borrow();
    	borrow.setBorrowDate(DEFAULT_BORROW_DATE);
    	borrow.setReturnDate(DEFAULT_RETURN_DATE);
    	return borrow;
    }
    
    @BeforeEach
    public void init() {
        user = createUserEntity();
        item = createItemEntity();
        borrow = createBorrowEntity();
    }

	@Test
	public void getBorrowByUserId() throws Exception {
		// préparation des données
		userRepository.save(user);
		itemRepository.save(item);
		borrow.setUser(user);
		Set<Item> item1 = new HashSet<>();
		item1.add(item);
		borrow.setItems(item1);
		borrowRepository.save(borrow);
		
		Borrow borrow2 = createBorrowEntity();
		borrow2.setUser(user);
		Set<Item> item2 = new HashSet<>();
		item2.add(item);
		borrow2.setItems(item2);
		borrowRepository.save(borrow2);
		
		// exécuter le code à tester
		List<Borrow> getBorrows = borrowRepository.findByUser_Id(user.getId());
		
		// vérifier les données
		assertThat(getBorrows.size()).isEqualTo(2);
	}

}
