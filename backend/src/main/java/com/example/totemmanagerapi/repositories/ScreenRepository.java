package com.example.totemmanagerapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.totemmanagerapi.domain.screen.Screen;

public interface ScreenRepository extends JpaRepository <Screen, String>{
    Optional<Screen> findByName(String name);
}
