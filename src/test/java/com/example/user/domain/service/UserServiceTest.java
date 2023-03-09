package com.example.user.domain.service;

import com.example.user.SpringBootBaseTest;
import com.example.user.application.web.UserController;
import com.example.user.domain.model.User;
import com.example.user.domain.repository.UserRepository;
import com.example.user.impl.domain.error.UserAlreadyExistAuthenticationException;
import com.github.database.rider.core.api.dataset.DataSetFormat;
import com.github.database.rider.core.api.exporter.ExportDataSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.ServerException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends SpringBootBaseTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Mock
    User user;

    @BeforeEach
    void setUp(){
        user = new User();
    }

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/service/user_login_succeed.json")
    void checkLoginSucceed() throws ServerException {

        User user = new User();
        user.setEmail("admin@email.com");
        user.setPassword("123");

        assertThat(userController.authUser(user, null)).isNotNull();

    }

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/user_wrong_pass.json")
    void checkLoginWrongPass() {

        Exception exception = assertThrows(ServerException.class, () -> {
            User user = new User();
            user.setEmail("admin@email.com");
            user.setPassword("1234");
            userController.authUser(user, null);
        });

        String expectedMessage = "Wrong Password";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/user_can_register.json")
    void checkIfCanRegisterUserAccount() {
        user.setUsername("anton");
        user.setPassword("321");
        user.setEmail("anton@example.com");
        User result = assertDoesNotThrow(() -> userService.registerNewUserAccount(user));
        Optional<User> actual = Optional.ofNullable(result);
        assertFalse(actual.isEmpty());
        String expected = user.getEmail();
        assertEquals(expected, result.getEmail());
    }

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/service/user_cannot_register.json")
    void checkIfCannotRegisterUserAccount() {

        Exception exception = assertThrows(UserAlreadyExistAuthenticationException.class, () -> {
            user.setUsername("anton");
            user.setPassword("321");
            user.setEmail("anton@anton.com");

            userService.registerNewUserAccount(user);
            userService.registerNewUserAccount(user);
        });

        String expectedMessage = "There is an account with that email address: "
                + user.getEmail();
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @AfterEach
    void deleteTestRegis(){
        userRepository.removeUser(user.getEmail());
    }

}