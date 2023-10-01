package com.example.polls.controller;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.polls.model.ReservationTerrain;
import com.example.polls.model.StringResponse;
import com.example.polls.model.User;
import com.example.polls.service.ReservationService;
import com.example.polls.service.TransactionService;
import com.example.polls.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class MyAdminController {
	
	
	 @Autowired
	    private UserService userService;

	    @Autowired
	    private ReservationService productService;

	    @Autowired
	    private TransactionService transactionService;

	    @PutMapping("/api/admin/user-update")
	    public ResponseEntity<?> updateUser(@RequestBody User user) {
	        User existUser = userService.findByUsername(user.getUsername());
	        if (existUser != null && !existUser.getId().equals(user.getId())) {
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
	        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
	    }

	    //This can be also @DeleteMapping.
	    @PostMapping("/api/admin/user-delete")
	    public ResponseEntity<?> deleteUser(@RequestBody User user){
	        userService.deleteUser(user.getId());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/user-all")
	    public ResponseEntity<?> findAllUsers(){
	        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/user-number")
	    public ResponseEntity<?> numberOfUsers(){
	        Long number = userService.numberOfUsers();
	        StringResponse response = new StringResponse();
	        response.setResponse(number.toString());
	        //to return it, we will use String Response because long is not a suitable response for rest api
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	    @PostMapping("/api/admin/product-create")
	    public ResponseEntity<?> createProduct(@RequestBody ReservationTerrain product){
	        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	    }

	    @PutMapping("/api/admin/product-update")
	    public ResponseEntity<?> updateProduct(@RequestBody ReservationTerrain product){
	        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
	    }

	    //This can be also @DeleteMapping.
	    @PostMapping("/api/admin/product-delete")
	    public ResponseEntity<?> deleteProduct(@RequestBody ReservationTerrain product){
	        productService.deleteProduct(product.getId());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/product-all")
	    public ResponseEntity<?> findAllProducts(){
	        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/product-number")
	    public ResponseEntity<?> numberOfProducts(){
	        Long number = productService.numberOfProducts();
	        StringResponse response = new StringResponse();
	        response.setResponse(number.toString());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/transaction-all")
	    public ResponseEntity<?> findAllTransactions(){
	        return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
	    }

	    @GetMapping("api/admin/transaction-number")
	    public ResponseEntity<?> numberOfTransactions(){
	        Long number = transactionService.numberOfTransactions();
	        StringResponse response = new StringResponse();
	        response.setResponse(number.toString());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

}
