package com.theusp2p.event_manager.repositories;

import com.theusp2p.event_manager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
