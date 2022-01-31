package com.example.library_managment.controller;

import com.example.library_managment.model.Users;
import com.example.library_managment.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuhController {


    private final UsersRepository usersRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid Users user){
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        usersRepository.save(user);
        HashMap hashMap=new HashMap();
        hashMap.put("message","User created !");
        return ResponseEntity.status(201).body(hashMap);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(HttpSession session){
        HashMap hashMap=new HashMap();
        hashMap.put("message", session.getId());
        return ResponseEntity.status(200).body(hashMap);
    }
}
