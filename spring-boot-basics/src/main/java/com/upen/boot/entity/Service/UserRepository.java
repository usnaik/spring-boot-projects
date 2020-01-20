package com.upen.boot.entity.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upen.boot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
