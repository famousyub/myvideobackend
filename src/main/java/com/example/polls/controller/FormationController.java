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

import com.example.polls.model.Formation;

import com.example.polls.payload.MediaResponse;
import com.example.polls.payload.MediaSharePayload;
import com.example.polls.repository.FormationRepository;


@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
public class FormationController {
	
	
	
	
	
	
	
	
	
private final String UPLOAD_DIR = "uploads/";
	
	@Autowired
	private FormationRepository mediaShareRepository;
	
	
	@PostMapping("/formation/createleave")
	public ResponseEntity<?> createLeave(@RequestParam("file") MultipartFile file,@RequestParam Map<String, String> requestParams) throws IOException{

	    String start = requestParams.get("tagy");
	    String end= requestParams.get("description");
	    String searchText = requestParams.get("serachtext");
	    String imagepath = requestParams.get("imagepath");
	 
	    String originalFileName = file.getOriginalFilename();
        String mimeType = file.getContentType();

        Formation video = new Formation();
        video.setDescription(end);
        video.setMediavideoContentType(mimeType);
        video.setMimeType(originalFileName);
        video.setTag(start);
        video.setMediavideo(file.getBytes());
        video.setName(originalFileName);
        video.setSearchtext(searchText);
        video.setThumbnail(imagepath);
        
        mediaShareRepository.save(video);
       

        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
        Files.createDirectories(uploadPath);

        String filePath = uploadPath.toString() + "/" + originalFileName;
        Files.write(Paths.get(filePath), file.getBytes());

        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
	   
	}
	
	
	
    @PostMapping("/formation")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file,@RequestParam("mediasharepayload") MediaSharePayload mediaSharePayload) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file");
        }

        String originalFileName = file.getOriginalFilename();
        String mimeType = file.getContentType();

        Formation video = new Formation();
        video.setDescription(mediaSharePayload.getMediadescription());
        video.setMediavideoContentType(mimeType);
        video.setTag(originalFileName);
        video.setMimeType(mediaSharePayload.getMediatagy());
        video.setMediavideo(file.getBytes());
        mediaShareRepository.save(video);
       

        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
        Files.createDirectories(uploadPath);

        String filePath = uploadPath.toString() + "/" + originalFileName;
        Files.write(Paths.get(filePath), file.getBytes());

        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
    }
    
    
    @GetMapping("/formation/all")
    public ResponseEntity<?> allmediashares()
    {
    	
    	
    	List<Formation> medias = mediaShareRepository.findAll();
    	List<MediaResponse> mediares = new ArrayList<>();
    	
    	for (Formation media : medias) {
    		MediaResponse mere = new MediaResponse();

        	String url_ = "http://localhost:8081/api/videos/formation/" + media.getId();
        	mere.setUrl_(url_);
        	mere.setId(media.getId());
        	
        	mere.setDescription(media.getDescription());
        	
        	mere.setTag(media.getTag());
        	
        	mere.setTagy(media.getMimeType());	
        	
        	mediares.add(mere);
		}
    	
    	return ResponseEntity.ok().body(mediares);
    	
    }
    
    @GetMapping("/formation/one/{id}")
    public ResponseEntity<?>  mediashareOne(@PathVariable("id") Long id)
    {
    	
    	Formation media = mediaShareRepository.findById(id).get();
    	
    	
    	String url_ = "http://localhost:8081/api/videos/formation/" + media.getId();
    	
    	MediaResponse mere = new MediaResponse();
    	
    	mere.setUrl_(url_);
    	mere.setId(media.getId());
    	
    	mere.setDescription(media.getDescription());
    	
    	mere.setTag(media.getSearchtext());
    	
    	mere.setTagy(media.getTag());
    	
    	return ResponseEntity.ok().body(mere);
    	
    	
    }
    @GetMapping("/formation/{id}")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) throws IOException {
    	Formation video = mediaShareRepository.findById(id).orElse(null);

        if (video == null) {
            return ResponseEntity.notFound().build();
        }

        Path videoPath = Paths.get(UPLOAD_DIR + video.getId() + "/" + video.getMimeType());
        byte[] videoBytes = Files.readAllBytes(videoPath);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, video.getMediavideoContentType())
                .body(videoBytes);
    }


}
