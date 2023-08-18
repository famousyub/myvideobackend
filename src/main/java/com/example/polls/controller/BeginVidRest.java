package com.example.polls.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.BeginVid;

import com.example.polls.payload.MediaResponse;
import com.example.polls.repository.BeginVidRepository;


@RestController
@RequestMapping("/api/beginVideo")
@CrossOrigin("*")
public class BeginVidRest {
	
private final String UPLOAD_DIR = "uploads/";
	
	@Autowired
	private BeginVidRepository mediaShareRepository;
	
	@GetMapping("/mediashare/all")
    public ResponseEntity<?> allmediashares()
    {
    	
    	
    	List<BeginVid> medias = mediaShareRepository.findAll();
    	List<MediaResponse> mediares = new ArrayList<>();
    	
    	for (BeginVid media : medias) {
    		MediaResponse mere = new MediaResponse();

        	String url_ = "http://localhost:8081/api/beginVideo/mediashare/" + media.getId();
        	mere.setUrl_(url_);
        	mere.setId(media.getId());
        	
        	mere.setDescription(media.getMimeType());
        	
        	mere.setTag(media.getPath());
        	
        	mere.setTagy(media.getTitle());	
        	
        	mediares.add(mere);
		}
    	
    	return ResponseEntity.ok().body(mediares);
    	
    }
    
    @GetMapping("/mediashare/one/{id}")
    public ResponseEntity<?>  mediashareOne(@PathVariable("id") Long id)
    {
    	
    	BeginVid media = mediaShareRepository.findById(id).get();
    	
    	
    	String url_ = "http://localhost:8081/api/beginVideo/mediashare/" + media.getId();
    	
    	MediaResponse mere = new MediaResponse();
    	
    	mere.setUrl_(url_);
    	mere.setId(media.getId());
    	
    	mere.setDescription(media.getMimeType());
    	
    	mere.setTag(media.getPath());
    	
    	mere.setTagy(media.getTitle());	
    	
    
    	return ResponseEntity.ok().body(mere);
    	
    	
    }
    @GetMapping("/mediashare/{id}")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) throws IOException {
    	BeginVid video = mediaShareRepository.findById(id).orElse(null);

        if (video == null) {
            return ResponseEntity.notFound().build();
        }

        Path videoPath = Paths.get(UPLOAD_DIR + video.getId() + "/" + video.getPath());
        byte[] videoBytes = Files.readAllBytes(videoPath);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, video.getMimeType())
                .body(videoBytes);
    }

	

}
