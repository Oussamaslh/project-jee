package com.example.salhioussamaproject.service;

import com.example.salhioussamaproject.Repository.UserRepository;
import com.example.salhioussamaproject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        // Vous pouvez ajouter des vérifications supplémentaires ici, par exemple,
        // vérifier si l'email est déjà utilisé avant d'enregistrer l'utilisateur

        userRepository.save(user);
    }
    public User authenticate(String email, String password) {
        System.out.println("Authenticating user with email: " + email);
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

