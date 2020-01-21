package com.upen.springsecurityjwtjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upen.springsecurityjwtjpa.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
