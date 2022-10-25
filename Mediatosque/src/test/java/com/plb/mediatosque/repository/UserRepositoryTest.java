package com.plb.mediatosque.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.plb.mediatosque.entity.User;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
    UserRepository userRepository;
	
	@Test
    public void shouldFindUserByLogin() {
		User userByLogin = userRepository.findByLogin("fwestbury@gmail.com");
        assertEquals("Fionna", userByLogin.getFirstName());
    }
	
}
