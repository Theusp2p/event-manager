package com.theusp2p.event_manager.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column
    private LocalDateTime date;
    @Column
    private String location;
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;


}
