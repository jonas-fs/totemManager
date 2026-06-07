package com.example.totemmanagerapi.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.totemmanagerapi.domain.image.Image;
import com.example.totemmanagerapi.dto.ImageDTO;
import com.example.totemmanagerapi.repository.ImageRepository;

@Service
public class imageService {

    private final ImageRepository imageRepository;

    // Injeção de dependência via construtor
    public imageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public static ImageDTO toDTO(Image image) {
        return new ImageDTO(
            image.getId(),
            image.getScreen().getId(),
            image.getScreen().getName()
        );
    }

    public List<ImageDTO> listAll(){
        return imageRepository.findAll()
                .stream()
                .map(imageService::toDTO)
                .toList();
    }
}
