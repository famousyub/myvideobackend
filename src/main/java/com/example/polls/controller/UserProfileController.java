package com.example.polls.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.model.User;
import com.example.polls.payload.UserResponse;
import com.example.polls.payload.UserSummary;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;



class ProfileRequest {
	
	private String phoneneumber ;
	
	private String bio ;

	public String getPhoneneumber() {
		return phoneneumber;
	}

	public void setPhoneneumber(String phoneneumber) {
		this.phoneneumber = phoneneumber;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public ProfileRequest() {
		super();
	}
	
}

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserProfileController {
	
	
	 @Autowired
	    private UserRepository userRepository;
	 
	 //user-profile
	 @GetMapping("/user/profile/me")
	   // @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> getCurrentUserlogin(@CurrentUser UserPrincipal currentUser) {
	        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
	        return ResponseEntity.ok().body(userSummary);
	    }
	 
	 
	 @GetMapping("/user-profile/{id}")
	 public ResponseEntity<?> userProfileId(@PathVariable("id") Long id)
	 {
		 
		 User  currentUser = userRepository.findById(id).get();
		 UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
	        return ResponseEntity.ok().body(userSummary);
		 
		 
	 }
	 
	 @GetMapping("/userme/{id}")
	 public ResponseEntity<?> userProfileIdall(@PathVariable("id") Long id)
	 {
		 
		 User  currentUser = userRepository.findById(id).get();
		 UserResponse userSummary = new UserResponse();
		 userSummary.setBio(currentUser.getBio());
		 userSummary.setId(currentUser.getId());
		 userSummary.setName(currentUser.getName());
		 userSummary.setEmail(currentUser.getEmail());
		 userSummary.setPhonenumber(currentUser.getPhonenumber());
		 userSummary.setUsername(currentUser.getUsername());
		 userSummary.setImageuser(currentUser.getImageprofile());
	        return ResponseEntity.ok().body(userSummary);
		 
		 
	 }
	 
	 
	 
	 @PostMapping("/user/profile/upload")
	    //@PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> updateUserimage(@CurrentUser UserPrincipal currentUser,@RequestParam("file") MultipartFile image) throws IOException {
	        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
	        
	        User _me = userRepository.findByUsername(userSummary.getUsername()).get();
	        
	       _me.setImageprofile(image.getBytes());
	        
	        userRepository.save(_me);
	        
	        
	        return ResponseEntity.ok().body(_me);
	    }
	 
	 @PostMapping("/user/profile/update")
	    //@PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> updateUserBioandphone(@CurrentUser UserPrincipal currentUser,@RequestBody ProfileRequest profileRequest) {
	        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
	        
	        User _me = userRepository.findByUsername(userSummary.getUsername()).get();
	        
	        _me.setPhonenumber(profileRequest.getPhoneneumber());
	        _me.setBio(profileRequest.getBio());
	        
	        userRepository.save(_me);
	        
	        
	        return ResponseEntity.ok().body(profileRequest);
	    }
	 
	 

}
