package com.theusp2p.event_manager.services;

import com.theusp2p.event_manager.entities.Event;
import com.theusp2p.event_manager.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

}
