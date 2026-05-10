package com.example.totemmanagerapi.infra.storege;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {        
    private final Path uploadPath;    

    private static final Set<String> ALLOWED_TYPES = Set.of(
            "image/jpeg",
            "image/png",
            "image/webp"
    );

    public StorageService (
        @Value("${app.upload.dir}") String uploadDir 
    ) throws IOException {
        this.uploadPath = Paths.get(uploadDir)
        .toAbsolutePath()
        .normalize();

        Files.createDirectories(this.uploadPath);
    }

    public Boolean save (MultipartFile file, String filename) throws IOException {
        validate(file);

        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        String fileName = filename + "." + extension;

        Path target = this.uploadPath.resolve(fileName);

        Files.copy(
                file.getInputStream(),
                target,
                StandardCopyOption.REPLACE_EXISTING
        );
        

        return true;
    }

    private void validate(MultipartFile file) {

        if (file.isEmpty()) {
            throw new IllegalArgumentException("Arquivo vazio");
        }

        if (!ALLOWED_TYPES.contains(file.getContentType())) {
            throw new IllegalArgumentException("Tipo inválido");
        }
    }
}
