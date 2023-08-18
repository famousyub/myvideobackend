package com.example.polls.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.model.Mediashare;
import com.example.polls.model.VideoEvent;
import com.example.polls.payload.MediaResponse;
import com.example.polls.payload.MediaSharePayload;
import com.example.polls.repository.MediaShareRepository;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
public class MediaShareController {
	
	
	private final String UPLOAD_DIR = "uploads/";
	
	@Autowired
	private MediaShareRepository mediaShareRepository;
	
	
	@PostMapping("/createleave")
	public ResponseEntity<?> createLeave(@RequestParam("file") MultipartFile file,@RequestParam Map<String, String> requestParams) throws IOException{

	    String start = requestParams.get("tagy");
	    String end= requestParams.get("description");
	 
	    String originalFileName = file.getOriginalFilename();
        String mimeType = file.getContentType();

        Mediashare video = new Mediashare();
        video.setMediadescription(end);
        video.setMediavideoContentType(mimeType);
        video.setMediatag(originalFileName);
        video.setMediatagy(start);
        video.setMediavideo(file.getBytes());
        mediaShareRepository.save(video);
       

        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
        Files.createDirectories(uploadPath);

        String filePath = uploadPath.toString() + "/" + originalFileName;
        Files.write(Paths.get(filePath), file.getBytes());

        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
	   
	}
	
	
	
    @PostMapping("/mediashare")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file,@RequestParam("mediasharepayload") MediaSharePayload mediaSharePayload) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file");
        }

        String originalFileName = file.getOriginalFilename();
        String mimeType = file.getContentType();

        Mediashare video = new Mediashare();
        video.setMediadescription(mediaSharePayload.getMediadescription());
        video.setMediavideoContentType(mimeType);
        video.setMediatag(originalFileName);
        video.setMediatagy(mediaSharePayload.getMediatagy());
        video.setMediavideo(file.getBytes());
        mediaShareRepository.save(video);
       

        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
        Files.createDirectories(uploadPath);

        String filePath = uploadPath.toString() + "/" + originalFileName;
        Files.write(Paths.get(filePath), file.getBytes());

        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
    }
    
    
    @GetMapping("/mediashare/all")
    public ResponseEntity<?> allmediashares()
    {
    	
    	
    	List<Mediashare> medias = mediaShareRepository.findAll();
    	List<MediaResponse> mediares = new ArrayList<>();
    	
    	for (Mediashare media : medias) {
    		MediaResponse mere = new MediaResponse();

        	String url_ = "http://localhost:8081/api/videos/mediashare/" + media.getId();
        	mere.setUrl_(url_);
        	mere.setId(media.getId());
        	
        	mere.setDescription(media.getMediadescription());
        	
        	mere.setTag(media.getMediatag());
        	
        	mere.setTagy(media.getMediatagy());	
        	
        	mediares.add(mere);
		}
    	
    	return ResponseEntity.ok().body(mediares);
    	
    }
    
    @GetMapping("/mediashare/one/{id}")
    public ResponseEntity<?>  mediashareOne(@PathVariable("id") Long id)
    {
    	
    	Mediashare media = mediaShareRepository.findById(id).get();
    	
    	
    	String url_ = "http://localhost:8081/api/videos/mediashare/" + media.getId();
    	
    	MediaResponse mere = new MediaResponse();
    	
    	mere.setUrl_(url_);
    	mere.setId(media.getId());
    	
    	mere.setDescription(media.getMediadescription());
    	
    	mere.setTag(media.getMediatag());
    	
    	mere.setTagy(media.getMediatagy());
    	
    	return ResponseEntity.ok().body(mere);
    	
    	
    }
    @GetMapping("/mediashare/{id}")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) throws IOException {
    	Mediashare video = mediaShareRepository.findById(id).orElse(null);

        if (video == null) {
            return ResponseEntity.notFound().build();
        }

        Path videoPath = Paths.get(UPLOAD_DIR + video.getId() + "/" + video.getMediatag());
        byte[] videoBytes = Files.readAllBytes(videoPath);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, video.getMediavideoContentType())
                .body(videoBytes);
    }

}
