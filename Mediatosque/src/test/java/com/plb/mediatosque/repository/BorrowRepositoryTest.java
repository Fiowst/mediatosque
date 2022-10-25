package com.plb.mediatosque.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.plb.mediatosque.entity.Borrow;

@DataJpaTest
public class BorrowRepositoryTest {
	
	@Autowired
	BorrowRepository borrowRepository;

	@Test
    public void shouldFindByUserId() {
		LocalDate localdate = LocalDate.of(2022, 10, 7);
        List<Borrow> borrowByUserId = borrowRepository.findByUser_Id(1L);
        assertEquals(localdate, borrowByUserId.get(0).getBorrowDate());
    }
}
