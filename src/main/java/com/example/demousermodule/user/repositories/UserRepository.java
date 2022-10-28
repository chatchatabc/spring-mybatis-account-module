package com.example.demousermodule.user.repositories;

import com.example.demousermodule.user.entities.User;
import org.jetbrains.annotations.Nullable;


public interface UserRepository {

    @Nullable
    User findOne(String email);

    @Nullable
    User insert(User user);


    void createTable();
}
