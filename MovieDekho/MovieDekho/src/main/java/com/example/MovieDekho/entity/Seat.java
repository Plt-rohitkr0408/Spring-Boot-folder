package com.example.MovieDekho.entity;

import com.example.MovieDekho.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="seats",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"screen_id", "seat_row", "seat_col"}
                )
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false , name="seat_col")
    private Integer col;

    @Column(nullable = false, name="seat_row")
    private String row;

    @Column(nullable = false)
    private String seatNumber ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

}
