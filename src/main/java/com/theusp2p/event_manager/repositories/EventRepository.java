package com.theusp2p.event_manager.repositories;

import com.theusp2p.event_manager.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
