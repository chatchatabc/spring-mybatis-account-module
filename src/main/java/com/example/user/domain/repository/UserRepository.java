package com.example.user.domain.repository;

import com.example.user.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User findUserByEmail(String email);

    Integer createUser(User user);

    void removeUser(String email);

}
