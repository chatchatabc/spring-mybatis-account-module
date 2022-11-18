package com.example.springmybatisaccountmodule.user.domain.repositories;

import com.example.springmybatisaccountmodule.user.domain.entities.User;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    @Nullable
    User findOne(String email);

    @Nullable
    int insert(User user);

    boolean delete(String email);

    void createTable();
}
