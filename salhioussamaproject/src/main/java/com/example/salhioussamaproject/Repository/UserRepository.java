package com.example.salhioussamaproject.Repository;

import com.example.salhioussamaproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer> {

    // Add custom query methods as needed
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
