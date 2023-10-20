package com.img.Event_organization.controller;

import com.img.Event_organization.entity.PlayerImage;
import com.img.Event_organization.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadImage(@RequestBody MultipartFile file) throws IOException {
        imageService.imageUpload(file);
        return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping("/download-image")
    public ResponseEntity<?> downloadImage(@RequestParam String filename) throws IOException {
        PlayerImage playerImage = imageService.downloadImage(filename);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(playerImage.getFiletype()))
                .body(Files.readAllBytes(new File(playerImage.getFilepath()).toPath()));
    }
}
