package com.example.MovieDekho.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="screens")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screen {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String screenNumber;

    @Column(nullable = false)
    private Integer totalSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="theater_id" , nullable = false)
    private Theater theater;

}
