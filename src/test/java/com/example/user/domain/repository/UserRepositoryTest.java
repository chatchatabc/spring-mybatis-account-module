package com.example.user.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserRepositoryTest {



    @Autowired
    private UserRepository userTest;

    @Test
    void checkThatUserExist() {
        boolean val = userTest.findOne("josh@josh.com") != null;

        assertThat(val).isEqualTo(true);

    }

    @Test
    void checkThatUserDoesNotExist() {
        boolean val = userTest.findOne("joshi@josh.com") != null;

        assertThat(val).isEqualTo(false);

    }


}