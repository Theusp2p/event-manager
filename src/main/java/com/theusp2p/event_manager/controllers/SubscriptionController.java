package com.theusp2p.event_manager.controllers;

import com.theusp2p.event_manager.dtos.SubscriptionRequestDTO;
import com.theusp2p.event_manager.dtos.SubscriptionResponseDTO;
import com.theusp2p.event_manager.entities.Subscription;
import com.theusp2p.event_manager.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    public final SubscriptionService subscriptionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Subscription>> findAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.findAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    @PostMapping
    public ResponseEntity<SubscriptionResponseDTO> createSubscription(@RequestBody SubscriptionRequestDTO subscriptionRequestDTO) {
        SubscriptionResponseDTO newSubscription = subscriptionService.crateSubscription(subscriptionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSubscription);

    }



}
