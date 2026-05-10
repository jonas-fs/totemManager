package com.example.totemmanagerapi.dto;

import org.springframework.web.multipart.MultipartFile;

public record ImageDTO(String id, MultipartFile file) {

}