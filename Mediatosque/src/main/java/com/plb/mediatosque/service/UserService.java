package com.plb.mediatosque.service;

import org.springframework.stereotype.Service;

import com.plb.mediatosque.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
