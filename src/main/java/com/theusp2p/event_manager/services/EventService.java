package com.theusp2p.event_manager.services;

import com.theusp2p.event_manager.dtos.EventRequestDTO;
import com.theusp2p.event_manager.dtos.EventRequestDTO;
import com.theusp2p.event_manager.dtos.EventResponseDTO;
import com.theusp2p.event_manager.entities.Event;
import com.theusp2p.event_manager.entities.User;
import com.theusp2p.event_manager.repositories.EventRepository;
import com.theusp2p.event_manager.repositories.UserRepository;
import com.theusp2p.event_manager.services.mappers.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final EventMapper eventMapper;

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Transactional
    public EventResponseDTO createEvent(EventRequestDTO eventRequestDTO) {

        Event newEvent = eventMapper.toEntity(eventRequestDTO);

        User organizer = userRepository.findById(eventRequestDTO.organizerId()).orElseThrow( () -> new RuntimeException("User not found"));
        newEvent.setOrganizer(organizer);
        Event savedEvent = eventRepository.save(newEvent);

        return eventMapper.toDTO(savedEvent);
    }
}
