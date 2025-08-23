package com.theusp2p.event_manager.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.theusp2p.event_manager.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

public record EventRequestDTO(

        @NotBlank(message = "campo obrigatório")
        String title,
        @NotBlank(message = "campo obrigatório")
        String description,
        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        ZonedDateTime date,
        @NotBlank(message = "campo obrigatório")
        String location,
        @NotNull(message = "campo obrigatório")
        UUID organizerId
) {
}
