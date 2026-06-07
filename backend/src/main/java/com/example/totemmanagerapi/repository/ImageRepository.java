package com.example.totemmanagerapi.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.totemmanagerapi.domain.image.Image;

public interface ImageRepository extends JpaRepository <Image, String>{}
