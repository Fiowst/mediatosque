package com.plb.mediatosque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plb.mediatosque.entity.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>  {
	
	List<Borrow> findByUser_Id(Long id);
	
}
