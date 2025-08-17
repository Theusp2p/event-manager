package com.theusp2p.event_manager.controllers;

import com.theusp2p.event_manager.entities.Event;
import com.theusp2p.event_manager.repositories.EventRepository;
import com.theusp2p.event_manager.services.EventService;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.EventManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Event>> findAllEvents() {
        List<Event> events = eventService.findAllEvents();
        return ResponseEntity.ok(events);
    }

}
