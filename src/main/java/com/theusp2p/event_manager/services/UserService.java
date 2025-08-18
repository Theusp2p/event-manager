package com.theusp2p.event_manager.services;

import com.theusp2p.event_manager.entities.User;
import com.theusp2p.event_manager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(User user){
        return userRepository.save(user);
    }
}
