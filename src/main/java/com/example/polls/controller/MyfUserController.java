package com.example.polls.controller;



	import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.polls.model.Role;
import com.example.polls.model.RoleName;
import com.example.polls.model.Transaction;
import com.example.polls.model.User;
import com.example.polls.payload.LoginRequest;
import com.example.polls.security.JwtTokenProvider;
import com.example.polls.service.ProductService;
import com.example.polls.service.TransactionService;
import com.example.polls.service.UserService;

import java.security.Principal;
	import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

	@RestController
	@CrossOrigin("*")
	public class MyfUserController {

	    @Autowired
	    private JwtTokenProvider tokenProvider;

	    
	    @Autowired
	    AuthenticationManager authenticationManager;
	    @Autowired
	    private UserService userService;

	    @Autowired
	    private ProductService productService;

	    @Autowired
	    private TransactionService transactionService;

	    @PostMapping("/api/user/registration")
	    public ResponseEntity<?> registerdf(@RequestBody User user){
	        if(userService.findByUsername(user.getName())!=null){
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
			//default role.
	        
	        Role r = new Role();
	        Set<Role> roles=  new HashSet<>();
	        r.setName(RoleName.ROLE_ADMIN);
	        
	        Role r2 = new Role();
	      
	        r2.setName(RoleName.ROLE_USER);
	        
	        user.setRoles(roles);
	        
	        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	    }

	    @PostMapping("/api/user/login")
	    public ResponseEntity<?> getUserlogin(@Valid @RequestBody LoginRequest loginRequest){
			//principal = httpServletRequest.getUserPrincipal.
	      
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getUsernameOrEmail(),
	                        loginRequest.getPassword()
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String jwt = tokenProvider.generateToken(authentication);
	        User user = userService.findByUsername(loginRequest.getUsernameOrEmail());
	        user.setToken(jwt);

	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }


	    @PostMapping("/api/user/purchase")
	    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction){
	        transaction.setPurchaseDate(LocalDateTime.now());
	         transactionService.saveTransaction(transaction);
	         return new ResponseEntity<>(transaction, HttpStatus.CREATED);
	    }

	    @GetMapping("/api/user/products")
	    public ResponseEntity<?> getAllProducts(){
	        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	    }
	}
