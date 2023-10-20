package com.img.Event_organization.service;

import com.img.Event_organization.entity.PlayerImage;
import com.img.Event_organization.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public static final String FILE_PATH="C:/Media files/";

    public void imageUpload(MultipartFile file) throws IOException {
        String filePath=FILE_PATH+file.getOriginalFilename();
        imageRepository.save(PlayerImage.builder()
                .filename(file.getOriginalFilename())
                .filetype(file.getContentType())
                .filepath(filePath).build());
        file.transferTo(new File(filePath));
    }

    public PlayerImage downloadImage(String filename) throws FileNotFoundException {
        PlayerImage image=imageRepository.findByFilename(filename).orElseThrow(()->new FileNotFoundException("Invalid filename"));
        return image;
    }
}
