package com.img.Event_organization.repository;

import com.img.Event_organization.entity.PlayerImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<PlayerImage,Long> {
    Optional<PlayerImage> findByFilename(String filename);
}
