package com.example.polls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.model.VideoEvent;
import com.example.polls.repository.VideoEventRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
public class VideoEventController {
    private final String UPLOAD_DIR = "uploads/";

    @Autowired
    private VideoEventRepository videoRepository;

    @PostMapping
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file");
        }

        String originalFileName = file.getOriginalFilename();
        String mimeType = file.getContentType();

        VideoEvent video = new VideoEvent();
        video.setName(originalFileName);
        video.setMimeType(mimeType);
        videoRepository.save(video);

        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
        Files.createDirectories(uploadPath);

        String filePath = uploadPath.toString() + "/" + originalFileName;
        Files.write(Paths.get(filePath), file.getBytes());

        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) throws IOException {
    	VideoEvent video = videoRepository.findById(id).orElse(null);

        if (video == null) {
            return ResponseEntity.notFound().build();
        }

        Path videoPath = Paths.get(UPLOAD_DIR + video.getId() + "/" + video.getName());
        byte[] videoBytes = Files.readAllBytes(videoPath);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, video.getMimeType())
                .body(videoBytes);
    }
}

