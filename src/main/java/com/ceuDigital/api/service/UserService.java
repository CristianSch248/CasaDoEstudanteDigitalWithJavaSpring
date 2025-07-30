package com.ceuDigital.api.service;

import com.ceuDigital.api.domain.user.UserRequestDTO;
import com.ceuDigital.api.domain.user.User;
import com.ceuDigital.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDTO userDTO)
    {
        User newUser = new User();

        newUser.setName(userDTO.name());
        newUser.setEmail(userDTO.email());
        newUser.setPassword(userDTO.password());
        newUser.setType(userDTO.type());
        newUser.setPhone_number(userDTO.phone_number());

        userRepository.save(newUser);

        return newUser;
    }
}
