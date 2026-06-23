package com.example.MovieDekho.controller;

import com.example.MovieDekho.dto.BookingRequest;
import com.example.MovieDekho.entity.Booking;
import com.example.MovieDekho.entity.Seat;
import com.example.MovieDekho.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

   @PostMapping("/add")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request){
       return ResponseEntity.ok(bookingService.createBooking(request));
      }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
       return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
       return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/userId/{id}")
    public ResponseEntity<List<Booking>> getBookingByUserId(@PathVariable Long id){
       return ResponseEntity.ok(bookingService.getBookingByUserId(id));
    }

    @GetMapping("/showId/{id}")
    public ResponseEntity<List<Booking>> getBookingByShowId(@PathVariable Long id){
       return ResponseEntity.ok(bookingService.getBookingByShowId(id));
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<Booking> cancelBooking (@PathVariable Long bookingId){
       return ResponseEntity.ok(bookingService.cancelBooking(bookingId));
    }

    @GetMapping("/showID/{showId}")
    public ResponseEntity<List<Seat>> getAvailableSeats(Long showId){
       return ResponseEntity.ok(bookingService.getAvailableSeats(showId));
    }
}
