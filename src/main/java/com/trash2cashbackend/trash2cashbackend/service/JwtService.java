package com.trash2cashbackend.trash2cashbackend.service;


import com.trash2cashbackend.trash2cashbackend.dto.request.LoginRequestDTO;
import com.trash2cashbackend.trash2cashbackend.dto.response.LoginResponse;
import com.trash2cashbackend.trash2cashbackend.entity.User;
import com.trash2cashbackend.trash2cashbackend.entity.enums.RoleEnum;
import com.trash2cashbackend.trash2cashbackend.repo.UserRepo;
import com.trash2cashbackend.trash2cashbackend.utill.JwtUtil;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthority(user)

            );
        }else {
            throw new UsernameNotFoundException("Use not found with username: "+ username);
        }
    }
    private Set getAuthority(User user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));

//        for (RoleEnum roleEnum : RoleEnum.values()){
//            authorities.add(new SimpleGrantedAuthority(roleEnum.toString()));
//        }
        return authorities;
    }

    public LoginResponse createJwtToken(LoginRequestDTO loginRequestDTO) throws Exception {
        String username = loginRequestDTO.getUsername();
        String password = loginRequestDTO.getPassword();

        authenticate(username,password);

        UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userRepo.findByUsername(username);

        LoginResponse loginResponse = new LoginResponse(
                user,
                newGeneratedToken
        );

        return loginResponse;
    }

    private void authenticate(String username, String password) throws  Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }
    }
}
