package com.trash2cashbackend.trash2cashbackend.service;

import com.trash2cashbackend.trash2cashbackend.dto.request.RequestUserSaveDTO;
import com.trash2cashbackend.trash2cashbackend.entity.User;
import com.trash2cashbackend.trash2cashbackend.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(RequestUserSaveDTO requestUserSaveDTO) {
        User user = modelMapper.map(requestUserSaveDTO,User.class);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            if(!userRepo.existsById(user.getUser_id()) && !userRepo.existsByUsername(user.getUsername()) ){
                userRepo.save(user);
                return "Save user";
            }else {
                return "User not save";
            }
    }

}
