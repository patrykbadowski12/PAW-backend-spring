package com.paw.service;

import com.paw.entity.UserEntity;
import com.paw.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity getUser(String username){
        return userRepository.findByUsername(username);
    }
}
