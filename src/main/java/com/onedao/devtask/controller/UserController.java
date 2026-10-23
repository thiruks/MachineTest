package com.onedao.devtask.controller;

import com.onedao.devtask.model.User;
import com.onedao.devtask.model.UserRequest;
import com.onedao.devtask.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {


    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserRequest request){
        if(userService.findByUsername(request.getUsername(), request.getPassword()) != null)
            return ResponseEntity.ok("Welcome " + request.getUsername());
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not found");
    }
    @PostMapping("/registration")
    public ResponseEntity<String> signup(@Valid @RequestBody UserRequest request){

        //To do create the new USer
        User u = new User();
        if(userService.signUp(u) != null)
            return ResponseEntity.ok( request.getUsername() + " is registered.");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not registered.");
    }

    @PostMapping("/OTP")
    public String otp(){
        return "Hi .otp";
    }


}
