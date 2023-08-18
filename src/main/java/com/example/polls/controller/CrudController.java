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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.model.Mediashare;
import com.example.polls.payload.FileUploadResponse;
import com.example.polls.payload.MediaSharePayload;
import com.example.polls.repository.FormationRepository;
import com.example.polls.repository.MediaShareRepository;
import com.example.polls.repository.VideoEventRepository;

@Controller
@RequestMapping("/api/crud")
public class CrudController {
	
	// CRUD operations (Create, Read, Update, Delete)

	 private final String UPLOAD_DIR = "uploads/";

	 @Autowired
	    private MediaShareRepository mediaShareRepository;

	    
	    @Autowired
	    private FormationRepository formationRepository;
	    
	    @Autowired
	    private VideoEventRepository videoEventRepository;
	    
	    
	 





		@GetMapping(value = {"/myvideo", "/homevideo"})
		public String addProductPage() {
			return "myvideo";
		}

		@PostMapping("/video/saveImageDetails")
		public @ResponseBody ResponseEntity<?> createProduct(@RequestParam("tagy") String name,
				 @RequestParam("description") String description, Model model, HttpServletRequest request
				,final @RequestParam("image") MultipartFile file) {
		
			try {
				//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
				String uploadDirectory = request.getServletContext().getRealPath(UPLOAD_DIR);
		
				
				
				String fileName_ = StringUtils.cleanPath(file.getOriginalFilename());
		        long size = file.getSize();
		     
		       
		         
		        FileUploadResponse response = new FileUploadResponse();
		        response.setFileName(fileName_);
		        response.setSize(size);
		        response.setDownloadUri("/downloadFile/" + fileName_);
		         
		       
				
				String fileName = file.getOriginalFilename();
				String filePath = Paths.get(uploadDirectory, fileName).toString();
			
				if (fileName == null || fileName.contains("..")) {
					model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
					return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
				}
				String[] names = name.split(",");
				String[] descriptions = description.split(",");
				Date createDate = new Date();
			
				try {
					File dir = new File(uploadDirectory);
					if (!dir.exists()) {
					
						dir.mkdirs();
					}
					// Save the file locally
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
					stream.write(file.getBytes());
					stream.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				Mediashare imageGallery = new Mediashare();
				byte[] imageData=compressBytes(file.getBytes());
				String originalFileName = file.getOriginalFilename();
		        String mimeType = file.getContentType();
		      
		        Mediashare video = new Mediashare();
		        video.setMediadescription(description);
		        video.setMediavideoContentType(mimeType);
		        video.setMediatag(originalFileName);
		        video.setMediatagy(name);
		        video.setMediavideo(imageData);
		        mediaShareRepository.save(video);
		       

		        Path uploadPath = Paths.get(UPLOAD_DIR + video.getId() + "/");
		        Files.createDirectories(uploadPath);

		    
		
				return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
			
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		@GetMapping("/video/display/{id}")
		@ResponseBody
		void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<Mediashare> imageGallery)
				throws ServletException, IOException {
			
			imageGallery = mediaShareRepository.findById(id);
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif ,video/* ");
			response.getOutputStream().write(imageGallery.get().getMediavideo());
			response.getOutputStream().close();
		}

		@GetMapping("/video/imageDetails")
		String showProductDetails(@RequestParam("id") Long id, Optional<Mediashare> imageGallery, Model model) {
			try {
			
				if (id != 0) {
					imageGallery = mediaShareRepository.findById(id);
				
				
					if (imageGallery.isPresent()) {
						model.addAttribute("id", imageGallery.get().getId());
						model.addAttribute("description", imageGallery.get().getMediadescription());
						model.addAttribute("name", imageGallery.get().getMediatagy());
						model.addAttribute("numbervideo", imageGallery.get().getMediavideoContentType());
						return "myvideodetails";
					}
					return "redirect:/homevideo";
				}
			return "redirect:/homevideo";
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:/homevideo";
			}	
		}

		@GetMapping("/video/show")
		String show(Model map) {
			List<Mediashare> images = mediaShareRepository.findAll();
			map.addAttribute("images", images);
			return "videos";
		}

		
		// compress the image bytes before storing it in the database
			public static byte[] compressBytes(byte[] data) {
				Deflater deflater = new Deflater();
				deflater.setInput(data);
				deflater.finish();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				while (!deflater.finished()) {
					int count = deflater.deflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				try {
					outputStream.close();
				} catch (IOException e) {
				}
				System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
				return outputStream.toByteArray();
			}
			// uncompress the image bytes before returning it to the angular application
			public static byte[] decompressBytes(byte[] data) {
				Inflater inflater = new Inflater();
				inflater.setInput(data);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				try {
					while (!inflater.finished()) {
						int count = inflater.inflate(buffer);
						outputStream.write(buffer, 0, count);
					}
					outputStream.close();
				} catch (IOException ioe) {
				} catch (DataFormatException e) {
				}
				return outputStream.toByteArray();
			}

	    
	    
	    
	    

    @GetMapping("/list")
    public String listMediaShares2(Model model) {
        List<Mediashare> mediaShares = mediaShareRepository.findAll();
        model.addAttribute("mediaShares", mediaShares);
        return "media_share_list";
    }

    // Add other CRUD methods

    // Upload video form
    @GetMapping("/upload")
    public String uploadVideoForm2(Model model) {
        model.addAttribute("mediaSharePayload", new MediaSharePayload());
        return "upload_form";
    }

    @PostMapping("/uploads")
    public String uploadVideo2(@RequestParam("file") MultipartFile file,
                              @ModelAttribute MediaSharePayload mediaSharePayload) throws IOException {
        // Implement your file upload logic here
        return "redirect:/videos/list";
    }
    
    
    
    @GetMapping("/list2")
    public String listMediaSharesh2(Model model) {
        List<Mediashare> mediaList = mediaShareRepository.findAll();
        model.addAttribute("mediaList", mediaList);
        return "list";
    }
    
    @GetMapping("/create2")
    public String showCreateForm1(Model model) {
        model.addAttribute("mediaShare", new Mediashare());
        return "create";
    }
    
    @PostMapping("/create")
    public String createMediaShare(@ModelAttribute Mediashare mediaShare) {
        mediaShareRepository.save(mediaShare);
        return "redirect:/mediashares/list";
    }

}
