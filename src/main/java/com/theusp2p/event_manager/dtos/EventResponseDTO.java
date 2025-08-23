package com.theusp2p.event_manager.dtos;


import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

public record EventResponseDTO(
        UUID id,
        String title,
        String description,
        ZonedDateTime date,
        String location,
        String organizer
) {
}
