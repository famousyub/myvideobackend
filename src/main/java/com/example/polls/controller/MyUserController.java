package com.example.polls.controller;

import com.example.polls.model.Role;
import com.example.polls.model.RoleName;
import com.example.polls.model.Transaction;
import com.example.polls.model.User;
import com.example.polls.payload.JwtAuthenticationResponse;
import com.example.polls.payload.LoginRequest;
import com.example.polls.security.JwtTokenProvider;
import com.example.polls.service.ReservationService;
import com.example.polls.service.TransactionService;
import com.example.polls.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")
public class MyUserController {
	
	
	 private UserService userService;

	    @Autowired
	    private ReservationService productService;

	    @Autowired
	    private TransactionService transactionService;
	    
	    @Autowired
	    JwtTokenProvider tokenProvider;

	    @Autowired
	    AuthenticationManager authenticationManager;
	    @PostMapping("/api/userr/registration")
	    public ResponseEntity<?> register(@RequestBody User user){
	        if(userService.findByUsername(user.getUsername())!=null){
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
	        Role r = new Role();
	        r.setName(RoleName.ROLE_USER);
			//default role.
	        user.setRoles(Set.of(r));
	        
	        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	    }

	    @GetMapping("/api/userr/login")
	    public ResponseEntity<?> getUser(@Valid @RequestBody LoginRequest loginRequest){
			//principal = httpServletRequest.getUserPrincipal.
	        
	   
	        

	        
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getUsernameOrEmail(),
	                        loginRequest.getPassword()
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String jwt = tokenProvider.generateToken(authentication);
	        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	       
	    }


	    @PostMapping("/api/userr/purchase")
	    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction){
	        transaction.setPurchaseDate(LocalDateTime.now());
	         transactionService.saveTransaction(transaction);
	         return new ResponseEntity<>(transaction, HttpStatus.CREATED);
	    }

	    @GetMapping("/api/userr/products")
	    public ResponseEntity<?> getAllProducts(){
	        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	    }

}
