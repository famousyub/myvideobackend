package com.example.polls.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.model.BeginVid;
import com.example.polls.model.Formation;
import com.example.polls.model.Mediashare;
import com.example.polls.model.VideoEvent;
import com.example.polls.payload.FileUploadResponse;
import com.example.polls.payload.FormationPayload;
import com.example.polls.payload.MediaSharePayload;
import com.example.polls.payload.Response;
import com.example.polls.repository.FormationRepository;
import com.example.polls.repository.MediaShareRepository;
import com.example.polls.repository.VideoEventRepository;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/admin/videos")
public class AdminControler {
    private final String UPLOAD_DIR = "uploads/";

   
    
    @Autowired
    private FormationRepository formationRepository;
    
    @Autowired
    private MediaShareRepository mediaShareRepository;
    
    @Autowired
    private VideoEventRepository eventRepository;
    
    @GetMapping
     public String navs() {
        return "navs";
    }
    
    @GetMapping("/uploadimage") public String displayUploadForm() {
        return "cvideo";
    }
    
    @GetMapping("/formation") public String formations() {
        return "formation";
    }
 
    
    @GetMapping("/myformation") public String myformations() {
        return "cvideo";
    }
 
 
 @PostMapping("/uploadformation")
    public String uploadVideo(Model model,@RequestParam("image") MultipartFile file , @RequestParam("tag") String tag , @RequestParam("description") String description  , @RequestParam("thumbnail") String thumbnail , @RequestParam("searchText") String searchText ,@RequestParam("category") String cat ) throws IOException {
        if (file.isEmpty()) {
        	  model.addAttribute("msg", "error uploading");
            return "cvideo"  ;
        }
       
        
   

        String originalFileName = file.getOriginalFilename();
        String mimeType = file.getContentType();

        Formation video = new Formation();
        video.setDescription(description);
        video.setMediavideoContentType(mimeType);
        video.setMimeType(originalFileName);
        video.setTag(tag);
        video.setMediavideo(file.getBytes());
        video.setName(originalFileName);
        video.setSearchtext(searchText);
        video.setThumbnail(thumbnail);
        video.setCategory(cat);
        
        formationRepository.save(video);

        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
        Files.createDirectories(uploadPath);

        String filePath = uploadPath.toString() + "/" + originalFileName;
        Files.write(Paths.get(filePath), file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + originalFileName);
        return "cvideo";
    }

 
 @GetMapping("/uploadmedial") public String displayUploadFormmedia() {
     return "media";
 }
 

 @PostMapping("/uploadmedia")
    public String uploadMedia(Model model,@RequestParam("image") MultipartFile file , @RequestParam("tag") String tag , @RequestParam("description") String description  , @RequestParam("thumbnail") String thumbnail , @RequestParam("searchText") String searchText  ) throws IOException {
        if (file.isEmpty()) {
        	  model.addAttribute("msg", "error uploading");
            return "media"  ;
        }
       
        
   

        String originalFileName = file.getOriginalFilename();
        String mimeType = file.getContentType();

        Mediashare video = new Mediashare();
        video.setMediadescription(description);
        video.setMediavideoContentType(mimeType);
     
        video.setMediatag(originalFileName);
        video.setMediavideo(file.getBytes());
     
        video.setMediatagy(searchText);
     
        
        mediaShareRepository.save(video);

        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
        Files.createDirectories(uploadPath);

        String filePath = uploadPath.toString() + "/" + originalFileName;
        Files.write(Paths.get(filePath), file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + originalFileName);
        return "media";
    }

 @GetMapping("/uploadeventm") public String displayUploadFormevent() {
     return "event";
 }
 
 @PostMapping("/uploadevent")
 public String uploadMediaevent(Model model,@RequestParam("image") MultipartFile file   ) throws IOException {
     if (file.isEmpty()) {
     	  model.addAttribute("msg", "error uploading");
         return "event"  ;
     }
    
     


     String originalFileName = file.getOriginalFilename();
     String mimeType = file.getContentType();

     VideoEvent video = new VideoEvent();
     video.setName(originalFileName);
     video.setMimeType(mimeType);
     eventRepository.save(video);

     Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
     Files.createDirectories(uploadPath);

     String filePath = uploadPath.toString() + "/" + originalFileName;
     Files.write(Paths.get(filePath), file.getBytes());
     model.addAttribute("msg", "Uploaded images: " + originalFileName);
     return "event";
 }

    
    
    
    
}
