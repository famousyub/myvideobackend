package com.example.polls.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Video;
import com.example.polls.repository.UploadMediaRepository;

import java.util.Optional;

@Repository
public class UploadMediaDao {

    @Autowired
    private UploadMediaRepository repository;

    public Optional<Video> findById(Long id) {
        return repository.findById(id);
    }

    public Video upload(Video value) {
        return repository.save(value);
    }

    public void convert(Video value) {
        repository.convertFileSuccess(value.getId(), value.getCompressedFilePath());
    }

    public void generateThumbnail(Video media) {
        repository.generateThumbnail(media.getId(), media.getThumbnailPath());
    }
}