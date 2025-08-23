package com.theusp2p.event_manager.dtos;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

public record SubscriptionResponseDTO(
        UUID id,
        String username,
        String eventTitle,
        ZonedDateTime subscriptionDate
) {
}
