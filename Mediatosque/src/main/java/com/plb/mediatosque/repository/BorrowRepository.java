package com.plb.mediatosque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.mediatosque.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long>  {
	
	// Retrouver les emprunts d'un user
	List<Borrow> findAllByUser_Id(long id);
}
