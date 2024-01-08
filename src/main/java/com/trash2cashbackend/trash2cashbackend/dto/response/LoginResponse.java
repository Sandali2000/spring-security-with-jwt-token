package com.trash2cashbackend.trash2cashbackend.dto.response;

import com.trash2cashbackend.trash2cashbackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponse {
    private User user;
    private String jwtToken;
}
