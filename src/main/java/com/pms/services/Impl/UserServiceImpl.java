package com.pms.services.Impl;


import com.pms.domain.model.User;
import com.pms.domain.repository.UserRepository;
import com.pms.services.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber()))
            throw new
                    IllegalArgumentException("This Account number already exists.");
        return this.userRepository.save(user);
    }
}
