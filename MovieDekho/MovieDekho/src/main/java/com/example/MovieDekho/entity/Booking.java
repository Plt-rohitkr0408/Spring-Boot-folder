package com.example.MovieDekho.entity;

import com.example.MovieDekho.enums.BokkingType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="booking")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="show_id", nullable = false)
    private Show show;

    @ManyToMany
    @JoinTable(name="booking_seat",
    joinColumns = @JoinColumn(name="booking_id"),
    inverseJoinColumns = @JoinColumn(name="seat_id"))
    private List<Seat> seats;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    private Double ticketPrice;

    @Enumerated(EnumType.STRING)
    private BokkingType status;

    @PrePersist
    protected void createBooking(){
        this.bookingDate = LocalDateTime.now();
        if(this.status == null){
            this.status = BokkingType.CONFIRMED;
        }
    }


}
