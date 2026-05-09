package com.example.totemmanagerapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.totemmanagerapi.domain.image.Image;
//import com.example.totemmanagerapi.domain.screen.Screen;
import com.example.totemmanagerapi.dto.ImageDTO;
import com.example.totemmanagerapi.repositories.ImageRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository repository;

    @PostMapping
    public ResponseEntity<ImageDTO> create(@RequestBody ImageDTO body){

        Image newImage = new Image();        
        this.repository.save(newImage);
        return ResponseEntity.ok(new ImageDTO(newImage.getId()));

        //return ResponseEntity.badRequest().build();
    }
}
