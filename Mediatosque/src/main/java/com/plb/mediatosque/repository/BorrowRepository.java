package com.plb.mediatosque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.mediatosque.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long>  {

}
