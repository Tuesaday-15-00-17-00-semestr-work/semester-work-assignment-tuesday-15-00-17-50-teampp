package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private String username;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional =
                userRepository.findByUsername(user.getUsername());
        if(userOptional.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        userRepository.save(user);
    }



    /*
    public List<User> getUsers() {
        return List.of(
                new User(
                        1L,
                        "patopoco",
                        "123",
                        1,
                        "jbmnt"
                )
        );

    }

   */
}
