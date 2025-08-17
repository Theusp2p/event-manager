package com.theusp2p.event_manager.repositories;

import com.theusp2p.event_manager.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
}
