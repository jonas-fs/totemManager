package com.example.totemmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.totemmanagerapi.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>{
    Optional<User> findByEmail(String email);

}