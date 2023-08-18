package com.example.polls.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.model.BeginVid;

import com.example.polls.repository.BeginVidRepository;

@Controller
@RequestMapping("/data")
public class BeginVigController {
	
	
	@Autowired
	private BeginVidRepository beginVidRepository;
	
	
	 private final String UPLOAD_DIR = "uploads/";

	 
	 @GetMapping("/uploadimage") public String displayUploadForm() {
	        return "BeginVid";
	    }
	 
	 @PostMapping("/upload")
	    public String uploadVideo(Model model,@RequestParam("image") MultipartFile file) throws IOException {
	        if (file.isEmpty()) {
	        	  model.addAttribute("msg", "error uploading");
	            return "BeginVid"  ;
	        }

	        String originalFileName = file.getOriginalFilename();
	        String mimeType = file.getContentType();

	        BeginVid video = new BeginVid();
	        video.setName(originalFileName);
	        video.setMimeType(mimeType);
	        video.setPath(originalFileName);
	        video.setTitle(mimeType);
	        video.setVideo(file.getBytes());
	        
	        beginVidRepository.save(video);

	        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
	        Files.createDirectories(uploadPath);

	        String filePath = uploadPath.toString() + "/" + originalFileName;
	        Files.write(Paths.get(filePath), file.getBytes());
	        model.addAttribute("msg", "Uploaded images: " + originalFileName);
	        return "BeginVid";
	    }

}
