package com.theusp2p.event_manager.dtos;

import com.theusp2p.event_manager.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventRequestDTO(

        @NotBlank(message = "campo obrigatório")
        String title,
        @NotBlank(message = "campo obrigatório")
        String description,
        LocalDateTime date,
        @NotBlank(message = "campo obrigatório")
        String location,
        @NotNull(message = "campo obrigatório")
        UUID organizerId
) {
}
