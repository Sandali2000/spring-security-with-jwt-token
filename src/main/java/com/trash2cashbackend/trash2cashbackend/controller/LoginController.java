package com.trash2cashbackend.trash2cashbackend.controller;

import com.trash2cashbackend.trash2cashbackend.dto.request.LoginRequestDTO;
import com.trash2cashbackend.trash2cashbackend.dto.response.LoginResponse;
import com.trash2cashbackend.trash2cashbackend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {

    @Autowired
    private JwtService jwtService;

    @PostMapping ({"/authentication"})
    public LoginResponse createJwtTokenAndLogin(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        return jwtService.createJwtToken(loginRequestDTO);
    }
}
