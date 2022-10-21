package com.plb.mediatosque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plb.mediatosque.entity.Borrow;
import com.plb.mediatosque.repository.BorrowRepository;

@Service
public class BorrowService {
	
	private BorrowRepository borrowRepository;

	public List<Borrow> getByUserId(long userId){
		return borrowRepository.findAllByUser_Id(userId);
	}
}
