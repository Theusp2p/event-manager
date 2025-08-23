package com.theusp2p.event_manager.services;

import com.theusp2p.event_manager.dtos.SubscriptionRequestDTO;
import com.theusp2p.event_manager.dtos.SubscriptionResponseDTO;
import com.theusp2p.event_manager.entities.Event;
import com.theusp2p.event_manager.entities.Subscription;
import com.theusp2p.event_manager.entities.User;
import com.theusp2p.event_manager.repositories.EventRepository;
import com.theusp2p.event_manager.repositories.SubscriptionRepository;
import com.theusp2p.event_manager.repositories.UserRepository;
import com.theusp2p.event_manager.services.mappers.SubscriptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public List<Subscription> findAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

    public SubscriptionResponseDTO crateSubscription(SubscriptionRequestDTO subscriptionRequestDTO) {

        User userFound = userRepository.findById(subscriptionRequestDTO.userId())
                .orElseThrow( () -> new RuntimeException("User not found"));

        Event eventFound = eventRepository.findById(subscriptionRequestDTO.eventId())
                .orElseThrow( () -> new RuntimeException("Event not found"));

        Subscription newSubscription = subscriptionMapper.toEntity(subscriptionRequestDTO);
        newSubscription.setUser(userFound);
        newSubscription.setEvent(eventFound);

        subscriptionRepository.save(newSubscription);

        return subscriptionMapper.toDTO(newSubscription);





    }
}
