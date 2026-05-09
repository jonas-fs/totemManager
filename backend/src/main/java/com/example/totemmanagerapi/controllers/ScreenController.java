package com.example.totemmanagerapi.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.totemmanagerapi.domain.screen.Screen;
import com.example.totemmanagerapi.dto.ScreenDTO;
import com.example.totemmanagerapi.repositories.ScreenRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/screen")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenRepository repository;
    
    @PostMapping
    public ResponseEntity<ScreenDTO> create(@RequestBody ScreenDTO body){
        Optional<Screen> screen = this.repository.findByName(body.name());
        
        if(screen.isEmpty()){
            Screen newScreen = new Screen();
            newScreen.setName(body.name());
            this.repository.save(newScreen);            
            
            return ResponseEntity.ok(new ScreenDTO(newScreen.getId(), ""));            
        }        

        return ResponseEntity.badRequest().build();
    }
}

