package com.example.user.domain.service;

import com.example.user.SpringBootBaseTest;
import com.example.user.domain.model.User;
import com.example.user.domain.repository.UserRepository;
import com.example.user.impl.domain.UserAlreadyExistAuthenticationException;
import com.github.database.rider.core.api.dataset.DataSetFormat;
import com.github.database.rider.core.api.exporter.ExportDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DBRider
class RegisterServiceTest extends SpringBootBaseTest {

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
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/user_can_register.json")
    void checkIfCanRegisterUserAccount() {
        user.setUsername("anton");
        user.setPassword("321");
        user.setEmail("anton@anton.com");
        int expected = 1;
        long actual = assertDoesNotThrow(() -> registerService.registerNewUserAccount(user));
        assertEquals(actual, expected);
    }

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/service/user_cannot_register.json")
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