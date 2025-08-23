package com.theusp2p.event_manager.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.UUID;

public record SubscriptionRequestDTO(
        @NotNull(message = "campo obrigatório")
        UUID userId,
        @NotNull(message = "campo obrigatório")
        UUID eventId,
        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
        ZonedDateTime subscriptionDate
) {
}
