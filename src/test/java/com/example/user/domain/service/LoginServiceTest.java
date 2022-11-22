package com.example.user.domain.service;

import com.example.user.application.web.LoginController;
import com.example.user.domain.model.User;
import com.example.user.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.rmi.ServerException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class LoginServiceTest {

    @Autowired
    private UserRepository userTest;

    @Autowired
    private LoginController loginTest;

    @Test
    void checkLoginSucceed() throws ServerException {

        User user = new User();
        user.setEmail("josh@josh.com");
        user.setPassword("123");


        assertThat(loginTest.getByEmail(user)).isNotNull();

    }

    @Test
    void checkLoginWrongPass() {

        Exception exception = assertThrows(ServerException.class, () -> {
            User user = new User();
            user.setEmail("josh@josh.com");
            user.setPassword("1234");
            loginTest.getByEmail(user);
        });

        String expectedMessage = "Wrong Password";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}
