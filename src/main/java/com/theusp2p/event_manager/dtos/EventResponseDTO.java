package com.theusp2p.event_manager.dtos;


import java.time.LocalDateTime;
import java.util.UUID;

public record EventResponseDTO(
        UUID id,
        String title,
        String description,
        LocalDateTime date,
        String location,
        UUID organizerId
) {
}
