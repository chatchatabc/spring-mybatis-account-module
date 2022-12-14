package com.example.user.domain.service;

import com.example.user.SpringBootBaseTest;
import com.example.user.application.web.LoginController;
import com.example.user.domain.model.User;
import com.example.user.domain.repository.UserRepository;
import com.github.database.rider.core.api.dataset.DataSetFormat;
import com.github.database.rider.core.api.exporter.ExportDataSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.ServerException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginServiceTest extends SpringBootBaseTest {

    @Autowired
    private UserRepository userTest;

    @Autowired
    private LoginController loginTest;

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/service/user_login_succeed.json")
    void checkLoginSucceed() throws ServerException {

        User user = new User();
        user.setEmail("admin@email.com");
        user.setPassword("123");


        assertThat(loginTest.getByEmail(user)).isNotNull();

    }

    @Test
    @ExportDataSet(format = DataSetFormat.JSON, outputName = "target/exported/user_wrong_pass.json")
    void checkLoginWrongPass() {

        Exception exception = assertThrows(ServerException.class, () -> {
            User user = new User();
            user.setEmail("admin@email.com");
            user.setPassword("1234");
            loginTest.getByEmail(user);
        });

        String expectedMessage = "Wrong Password";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}
