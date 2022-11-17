package com.example.springmybatisaccountmodule.user.controllers;

import com.example.springmybatisaccountmodule.user.Application.controllers.RegisController;
import com.example.springmybatisaccountmodule.user.Application.dto.UserRegisDto;
import com.example.springmybatisaccountmodule.user.Domain.repositories.UserRepository;
import com.example.springmybatisaccountmodule.user.Domain.services.RegisterService;
import com.example.springmybatisaccountmodule.user.Impl.UserAlreadyExistAuthenticationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisControllerTest {

    @Autowired
    private RegisController registerController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterService registerService;

    @Mock
    UserRegisDto newAccount;

    @BeforeEach
    void setUp(){
        newAccount = new UserRegisDto();
    }

    @AfterEach
    void deleteTestRegis(){
        userRepository.delete(newAccount.getEmail());
    }

    @Test
    void checkIfCanRegisterUserAccount() {
        newAccount = new UserRegisDto();
        newAccount.setUsername("anton");
        newAccount.setPassword("321");
        newAccount.setMatchingPassword("321");
        newAccount.setEmail("anton@anton.com");
        String actualMessage = registerController.registerUserAccount(newAccount,null,null);

        String expectedMessage = "redirect:/registration";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void checkIfCannotRegisterUserAccount() {

        Exception exception = assertThrows(UserAlreadyExistAuthenticationException.class, () -> {
            newAccount = new UserRegisDto();
            newAccount.setUsername("anton");
            newAccount.setPassword("321");
            newAccount.setMatchingPassword("321");
            newAccount.setEmail("anton@anton.com");

            registerService.registerNewUserAccount(newAccount);
            registerService.registerNewUserAccount(newAccount);
        });

        String expectedMessage = "There is an account with that email address: "
                + newAccount.getEmail();
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}