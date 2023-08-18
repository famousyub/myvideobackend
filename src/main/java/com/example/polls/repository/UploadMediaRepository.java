package com.example.polls.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.polls.model.Video;

public interface UploadMediaRepository extends CrudRepository<Video, Long> {

    @Modifying
    @Query("update Video set compressedFilePath = ?2, compressed = true where id = ?1")
    int convertFileSuccess(Long id, String path);

    @Modifying
    @Query("update Video set thumbnailPath = ?2, thumbnail = true where id = ?1")
    int generateThumbnail(Long id, String thumbnailPath);
}
