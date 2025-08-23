package com.theusp2p.event_manager.services.mappers;

import com.theusp2p.event_manager.dtos.EventRequestDTO;
import com.theusp2p.event_manager.dtos.EventResponseDTO;
import com.theusp2p.event_manager.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "organizer", ignore = true)
    Event toEntity(EventRequestDTO eventDTO);

    @Mapping(source = "organizer.name", target = "organizer")
    EventResponseDTO toDTO(Event event);

}
