package com.example.repository;

import com.example.model.MyUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<MyUser, Integer> {
    //MyUser findByLogin(String login);
    MyUser findRoleByLogin(String login);
    MyUser findByEmail(String email);

    Optional<MyUser> findByLogin(String login);
}
