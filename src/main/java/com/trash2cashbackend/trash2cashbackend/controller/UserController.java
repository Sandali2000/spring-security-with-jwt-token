package com.trash2cashbackend.trash2cashbackend.controller;

import com.trash2cashbackend.trash2cashbackend.utill.StandardResponse;
import com.trash2cashbackend.trash2cashbackend.dto.request.RequestUserSaveDTO;
import com.trash2cashbackend.trash2cashbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    //register new user
    @PostMapping("/registerNewUser")
    public ResponseEntity<StandardResponse> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO){
        try {
            String message = userService.saveUser(requestUserSaveDTO);
            return new ResponseEntity<>(
                    new StandardResponse(200, " ", message),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            // You can handle the exception according to your requirements.
            // For instance, logging the error or sending a different error response.
            return new ResponseEntity<>(
                    new StandardResponse(500, "error", "An error occurred while saving the user"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @GetMapping({"/get"})
    @PreAuthorize("hasRole('admin')")
    public String returnString(){
        return "Hello world admin";

    }

    @GetMapping({"/get1"})
    @PreAuthorize("hasAnyRole('user','admin')")
    public String returnString3(){
        return "Hello world user & admin";

    }

    @GetMapping({"/get2"})
    @PreAuthorize("hasRole('user')")
    public String returnString1(){
        return "Hello world user";

    }

}
