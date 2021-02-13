package com.example.disastermanagement.service;

import com.example.disastermanagement.models.User;
import com.example.disastermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiefServiceImpl implements ChiefService {

    private final UserRepository userRepository;

    @Autowired
    public ChiefServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userRepository.findById(id)
            .orElseThrow(() ->
                new UsernameNotFoundException(String.format("Username %s not found", id))
            ));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void addChief(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void updateChief(int id, User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteChief(int id) {
        userRepository.deleteById(id);
    }


}
