package com.example.totemmanagerapi.controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.totemmanagerapi.domain.image.Image;
import com.example.totemmanagerapi.domain.screen.Screen;
import com.example.totemmanagerapi.dto.ImageDTO;
import com.example.totemmanagerapi.repositories.ImageRepository;
import com.example.totemmanagerapi.repositories.ScreenRepository;
import com.example.totemmanagerapi.infra.storege.StorageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;
    private final ScreenRepository screenRepository;
    private final StorageService storgeService;

    @PostMapping
    public ResponseEntity<?> create(@RequestPart("file") MultipartFile file, @RequestPart("screenID") String screenID){
        
        Optional<Screen> screen = screenRepository.findById(screenID);

        if (screen.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Image newImage = new Image(screen.get());

        try {
            if(storgeService.save(file, newImage.getId())){
                newImage = this.imageRepository.save(newImage);
                //return ResponseEntity.ok(new ImageDTO(newImage.getId(), null)); //TO-DO avaliar esse trecho em relação ao response
                return ResponseEntity.created(null).build();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
