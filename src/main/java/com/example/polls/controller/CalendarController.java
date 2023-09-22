package  com.example.polls.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.bind.annotation.*;

import com.example.polls.model.ReservationTerrain;
import com.example.polls.service.CalendarService;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/calendar")
@CrossOrigin(origins = "*") // Assuming you're using localhost:4200 as your frontend
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/getReservations/{fieldId}")
    public ResponseEntity<?> getReservations(@PathVariable Long fieldId) {
        try {
            ReservationTerrain reservations = calendarService.getReservationsByFieldId(fieldId);
            return ResponseEntity.ok(reservations);
        } catch (ApplicationContextException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/createReservation")
    public ResponseEntity<?> createReservation(@RequestBody ReservationTerrain reservation) {
        try {
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
