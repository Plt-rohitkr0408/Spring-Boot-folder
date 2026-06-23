package com.example.MovieDekho.service;

import com.example.MovieDekho.dto.BookingRequest;
import com.example.MovieDekho.entity.Booking;
import com.example.MovieDekho.entity.Seat;
import com.example.MovieDekho.entity.Show;
import com.example.MovieDekho.entity.User;
import com.example.MovieDekho.enums.BokkingType;
import com.example.MovieDekho.respository.BookingRepository;
import com.example.MovieDekho.respository.SeatRepository;
import com.example.MovieDekho.service.intface.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements BookingServiceInterface {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserService userService;
    private final ShowService showService;


    @Override
    public Booking createBooking(BookingRequest request) {
        User user = userService.getUserById(request.getUserId());
        Show show = showService.getShowById(request.getShowId());

        List<Long> bookedSeat = bookingRepository.findBookedSeatsIdByShowId(show.getId());
        for(Long seatId : request.getSeatId()){
           if(bookedSeat.contains(seatId)){
                throw  new RuntimeException("Seat is already booked");
           }
        }
        List<Seat> seats = seatRepository.findAllById(request.getSeatId());
        if(seats.size() != request.getSeatId().size()){
            throw new RuntimeException("One or more seat is not found");
        }

        double ticketprice = request.getSeatId().size() * show.getTicketPrice();

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .ticketPrice(ticketprice)
                .status(BokkingType.CONFIRMED)
                .build();

        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Booking not found"));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingByUserId(Long id) {

        return bookingRepository.findByUserId(id);
    }

    @Override
    public List<Booking> getBookingByShowId(Long id) {
        return bookingRepository.findByShowId(id);
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(()-> new RuntimeException("Booking not found"));
        booking.setStatus(BokkingType.CANCELLED);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Seat> getAvailableSeats(Long showId) {
        Show show = showService.getShowById(showId);
        List<Seat> seats = seatRepository.findByScreenId(show.getScreen().getId());
        List<Long> bookedSeat = bookingRepository.findBookedSeatsIdByShowId(showId);

        return seats.stream()
                .filter(seat -> ! bookedSeat.contains(seat.getId()))
                .toList();
    }
}
