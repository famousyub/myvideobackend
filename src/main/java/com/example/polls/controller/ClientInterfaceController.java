package com.example.polls.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.DatabaseFile;
import com.example.polls.model.Favoutite;
import com.example.polls.model.Formation;
import com.example.polls.repository.FavoutiteRepository;
import com.example.polls.repository.FormationRepository;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;

@RestController
@RequestMapping("api/v1/cleint")
@CrossOrigin("*")
public class ClientInterfaceController {
	
	@Autowired
	private FormationRepository formationRepository;
	
	 @Autowired
	    private FavoutiteRepository wishlistItemRepository;

	
	@GetMapping("/{id}")
	public ResponseEntity<?> getForamationByid(@PathVariable("id") Long id)
	{
		
		Formation fomations = formationRepository.findById(id).get();
		return ResponseEntity.ok().body(fomations);
		
		
				
				
				
				
				
	}
	
	
	@GetMapping("/downloadFile/{id}")
    public ResponseEntity < ? > downloadFile(@PathVariable Long id, HttpServletRequest request) {
        // Load file as Resource
        Formation databaseFile = formationRepository.findById(id).get();

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(databaseFile.getMediavideoContentType()))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getName() + "\"")
            .body(new ByteArrayResource(databaseFile.getMediavideo()));
    }

	

	  @GetMapping("/favoure/{userId}")
	    public List<Favoutite> getUserWishlist(@PathVariable Long userId, @CurrentUser UserPrincipal currentUser) {
	        List<Favoutite> favourites = wishlistItemRepository.findAll().stream()
	                .filter(item -> item.getUser_id().equals(currentUser.getId()))
	                .collect(Collectors.toList());

	        return favourites;
	    }

	    @PostMapping("/favoure")
	    public Favoutite addToWishlist(@CurrentUser UserPrincipal currentUser, @RequestBody Favoutite wishlistItem) {
	       

	        wishlistItem.setUser_id(currentUser.getId());
	        return wishlistItemRepository.save(wishlistItem);
	    }

	   
	
	
	
	
	
	
	
	
	
	
	
}
