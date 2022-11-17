package com.example.springmybatisaccountmodule.user.repositories;

import com.example.springmybatisaccountmodule.user.Application.controllers.LoginController;
import com.example.springmybatisaccountmodule.user.Domain.repositories.UserRepository;
import com.example.springmybatisaccountmodule.user.Domain.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.rmi.ServerException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {



    @Autowired
    private UserRepository userTest;

    @Autowired
    private LoginController loginTest;

    @Test
    void checkThatUserExist_Repo() {
        boolean val = false;

       if(userTest.findOne("josh@josh.com") != null){
           val = true;
       }

       assertThat(val).isEqualTo(true);

    }

    @Test
    void checkThatUserDoesNotExist_Repo() {
        boolean val = false;

        if(userTest.findOne("joshi@josh.com") != null){
            val = true;
        }

        assertThat(val).isEqualTo(false);

    }

    @Test
    void checkLoginSucceed_Service() throws ServerException {

        User user = new User();
        user.setEmail("josh@josh.com");
        user.setPassword("123");


        assertThat(loginTest.getbyEmail(user)).isNotNull();

    }

    @Test
    void checkLoginWrongPass_Service() {

        Exception exception = assertThrows(ServerException.class, () -> {
            User user = new User();
            user.setEmail("josh@josh.com");
            user.setPassword("1234");
            loginTest.getbyEmail(user);
        });

        String expectedMessage = "Wrong Password";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }



}