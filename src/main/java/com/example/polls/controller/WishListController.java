package com.example.polls.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.Formation;
import com.example.polls.model.User;
import com.example.polls.model.Wishlist;
import com.example.polls.payload.MediaResponse;
import com.example.polls.repository.FormationRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.repository.WishlistRepository;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.WishlistService;

@RestController
@RequestMapping("api/v1/wishlist")
@CrossOrigin("*")
public class WishListController {
	
	@Autowired
	private WishlistService wishListService;
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	
	 @GetMapping("/userwishlist")
	    public ResponseEntity<List<Formation>> getWishList(@CurrentUser UserPrincipal currentUser) {
	    	User user = userRepository.findByUsername(currentUser.getUsername()).get();
	          
	            List<Wishlist> body = wishListService.readWishList(user.getId());
	            List<Formation> products = new ArrayList<Formation>();
	            for (Wishlist wishList : body) {
	                    products.add(wishList.getFormation());
	            }

	            return new ResponseEntity<List<Formation>>(products, HttpStatus.OK);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<?> addWishList(@RequestBody Formation product, @CurrentUser UserPrincipal currentUser) {
	    	User user = userRepository.findByUsername(currentUser.getUsername()).get();
	          
	            Wishlist wishList = new Wishlist(user.getId(), product);
	            wishList.setUser_id(user.getId());
	            wishListService.createWishlist(wishList);
	            return  ResponseEntity.ok().body("created add " +  HttpStatus.CREATED);

	    }
	    
	    @PostMapping("/formation/{user_id}/one/{id}")
	    public ResponseEntity<?>  mediashareOne(@PathVariable("id") Long id,@CurrentUser UserPrincipal currentUser,@PathVariable("user_id") Long user_id)
	    {
	    	
	    	Formation media = formationRepository.findById(id).get();
	    	
	    	
	    
	    	
	    	
	    	User user = userRepository.findByUsername(currentUser.getUsername()).get();
	          
	    	 System.out.print(currentUser.getId());
	    	
            Wishlist wishList = new Wishlist(user_id, media);
            wishList.setUser_id(currentUser.getId());
            wishlistRepository.save(wishList);
	    	
            return  ResponseEntity.ok().body("created add " +  HttpStatus.CREATED);
	    	
	    	
	    }

	
	

}
