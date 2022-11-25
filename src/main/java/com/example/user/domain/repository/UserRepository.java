package com.example.user.domain.repository;

import com.example.user.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User findOne(String email);

    long insert(User user);

    void delete(String email);

}
