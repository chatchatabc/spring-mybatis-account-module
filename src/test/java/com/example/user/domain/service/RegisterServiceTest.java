package com.example.user.domain.service;

import com.example.user.domain.model.User;
import com.example.user.domain.repository.UserRepository;
import com.example.user.impl.domain.UserAlreadyExistAuthenticationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RegisterServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterService registerService;

    @Mock
    User user;

    @BeforeEach
    void setUp(){
        user = new User();
    }

    @AfterEach
    void deleteTestRegis(){
        userRepository.delete(user.getEmail());
    }

    @Test
    void checkIfCanRegisterUserAccount() {
        user.setUsername("anton");
        user.setPassword("321");
        user.setEmail("anton@anton.com");
        int expected = 1;
        int actual = assertDoesNotThrow(() -> registerService.registerNewUserAccount(user));
        assertEquals(actual, expected);
    }

    @Test
    void checkIfCannotRegisterUserAccount() {

        Exception exception = assertThrows(UserAlreadyExistAuthenticationException.class, () -> {
            user.setUsername("anton");
            user.setPassword("321");
            user.setEmail("anton@anton.com");

            registerService.registerNewUserAccount(user);
            registerService.registerNewUserAccount(user);
        });

        String expectedMessage = "There is an account with that email address: "
                + user.getEmail();
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}