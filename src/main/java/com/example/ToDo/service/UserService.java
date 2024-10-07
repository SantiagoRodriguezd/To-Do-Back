package com.example.ToDo.service;

import com.example.ToDo.model.User;
import com.example.ToDo.repository.UserRepository;
import com.example.ToDo.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) throws AuthenticationException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();

            if (foundUser.getPassword().equals(password)) {
                return foundUser;
            } else {
                throw new AuthenticationException("Contraseña incorrecta");
            }
        } else {
            throw new AuthenticationException("Usuario no encontrado");
        }
    }
}
