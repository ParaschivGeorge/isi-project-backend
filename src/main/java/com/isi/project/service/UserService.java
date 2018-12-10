package com.isi.project.service;

import com.isi.project.entities.enums.UserType;
import com.isi.project.projections.UserRegister;
import com.isi.project.repository.UserRepository;
import com.isi.project.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(UserRegister userRegister) {
        userRepository.save(
                new User(
                        userRegister.getUsername(),
                        userRegister.getEmail(),
                        UserType.USER,
                        true,
                        bCryptPasswordEncoder.encode(userRegister.getPassword()),
                        new Date(),
                        new Date(),
                        new Date()
                        ));
    }


}
