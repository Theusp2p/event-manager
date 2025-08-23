package com.theusp2p.event_manager.services.mappers;

import com.theusp2p.event_manager.dtos.SubscriptionRequestDTO;
import com.theusp2p.event_manager.dtos.SubscriptionResponseDTO;
import com.theusp2p.event_manager.entities.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "event", ignore = true)
    Subscription toEntity(SubscriptionRequestDTO subscriptionRequestDTO);

    @Mapping(source = "user.name", target = "username")
    @Mapping(source = "event.title", target = "eventTitle")
    SubscriptionResponseDTO toDTO(Subscription subscription);

}
