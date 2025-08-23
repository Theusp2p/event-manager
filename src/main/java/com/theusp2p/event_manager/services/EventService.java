package com.theusp2p.event_manager.services;

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

    public EventResponseDTO findEventById(UUID id) {
        Event eventFound = eventRepository.findById(id).orElseThrow( () -> new RuntimeException("Event not found"));
        return eventMapper.toDTO(eventFound);

    }

    @Transactional
    public EventResponseDTO createEvent(EventRequestDTO eventRequestDTO) {

        User organizer = userRepository.findById(eventRequestDTO.organizerId()).orElseThrow( () -> new RuntimeException("User not found"));

        Event newEvent = eventMapper.toEntity(eventRequestDTO);

        newEvent.setOrganizer(organizer);
        Event savedEvent = eventRepository.save(newEvent);

        return eventMapper.toDTO(savedEvent);
    }

    public void deleteEventById(UUID id) {
        Event event = eventRepository.findById(id).orElseThrow( () -> new RuntimeException("Event not found"));
        eventRepository.delete(event);
    }

    public EventResponseDTO updateEventById(UUID id, EventRequestDTO eventRequestDTO) {
        Event eventFound = eventRepository.findById(id).orElseThrow( () -> new RuntimeException("Event not found"));

        if (eventRequestDTO.title() != null) {
            eventFound.setTitle(eventRequestDTO.title());
        }
        if (eventRequestDTO.description() != null) {
            eventFound.setDescription(eventRequestDTO.description());
        }
        if (eventRequestDTO.date() != null) {
            eventFound.setDate(eventRequestDTO.date());
        }
        if (eventRequestDTO.location() != null) {
            eventFound.setLocation(eventRequestDTO.location());
        }
        Event updatedEvent = eventRepository.save(eventFound);

        return eventMapper.toDTO(updatedEvent);
    }
}
