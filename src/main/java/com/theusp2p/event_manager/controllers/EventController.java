package com.theusp2p.event_manager.controllers;

import com.theusp2p.event_manager.dtos.EventRequestDTO;
import com.theusp2p.event_manager.dtos.EventResponseDTO;
import com.theusp2p.event_manager.entities.Event;
import com.theusp2p.event_manager.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Event>> findAllEvents() {
        List<Event> events = eventService.findAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> findEventById(@PathVariable UUID id) {
        EventResponseDTO eventFound = eventService.findEventById(id);
        return ResponseEntity.ok(eventFound);
    }

    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody EventRequestDTO eventRequestDTO) {
        EventResponseDTO newEvent = eventService.createEvent(eventRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventById(@PathVariable UUID id) {
        eventService.deleteEventById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EventResponseDTO> updateEventById(@PathVariable UUID id, @RequestBody EventRequestDTO eventRequestDTO) {
        EventResponseDTO eventUpdatedResponseDTO = eventService.updateEventById(id, eventRequestDTO);
        return ResponseEntity.ok(eventUpdatedResponseDTO);
    }


}
