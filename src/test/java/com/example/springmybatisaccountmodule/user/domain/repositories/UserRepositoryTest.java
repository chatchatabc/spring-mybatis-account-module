package com.example.springmybatisaccountmodule.user.domain.repositories;

import com.example.springmybatisaccountmodule.user.application.controllers.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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


}