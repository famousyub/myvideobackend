package  com.example.polls.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.bind.annotation.*;

import com.example.polls.model.Customer;
import com.example.polls.model.ReservationTerrain;
import com.example.polls.model.User;
import com.example.polls.repository.CustomerTerainRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.CalendarService;

import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/calendar")
@CrossOrigin(origins = "*") // Assuming you're using localhost:4200 as your frontend
public class CalendarController {

    @Autowired
    private CalendarService calendarService;
    
    @Autowired
    private UserRepository userrepo;
    
    @Autowired
    private CustomerTerainRepository customerTerainRepository;

    @GetMapping("/getReservations/{fieldId}")
    public ResponseEntity<?> getReservations(@PathVariable("fieldId") Long fieldId) {
        try {
            ReservationTerrain reservations = calendarService.getReservationsByFieldId(fieldId);
            return ResponseEntity.ok(reservations);
        } catch (ApplicationContextException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/createReservation")
    public ResponseEntity<?> createReservation(@RequestBody ReservationTerrain reservation,@CurrentUser UserPrincipal currentUser) {
        try {
       
        	 
        	 
        	 
       	 User  currentUser_ = userrepo.findById(currentUser.getId()).get();
        	 
       	Customer customer = new Customer();
       	customer.setEmailAddress(currentUser_.getEmail());
       	customer.setFirstName(currentUser.getName());
       	customer.setLastName(currentUser_.getUsername());
       	customer.setPhoneNo("000000000");
       	customerTerainRepository.save(customer);
       	
        	reservation.setCustomer(customer);
        	
        	reservation.setUser(currentUser_);        	
        	 

            calendarService.createReservation(reservation);
            return ResponseEntity.ok().build();
        } catch (ApplicationContextException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/getReservationById/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long  id) {
        try {
            ReservationTerrain reservations = calendarService.getReservationById(id);
            return ResponseEntity.ok(reservations);
        } catch (ApplicationContextException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/searchReservations/{title}")
    public ResponseEntity<?> searchReservations(@PathVariable String title) {
        try {
            List<ReservationTerrain> reservations = calendarService.searchReservations(title);
            return ResponseEntity.ok(reservations);
        } catch (ApplicationContextException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
