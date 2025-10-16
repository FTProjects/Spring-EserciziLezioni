package com.example.demo_spring_relazioni_db.controller;

import com.example.demo_spring_relazioni_db.model.User;
import com.example.demo_spring_relazioni_db.model.UserDetails;
import com.example.demo_spring_relazioni_db.repository.UserDetailsRepository;
import com.example.demo_spring_relazioni_db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class UserDetailController {

    private final UserDetailsRepository userDetailsRepository;


    @Autowired
    public UserDetailController(UserDetailsRepository userDetailsRepositor) {
        this.userDetailsRepository = userDetailsRepositor;
    }

    @GetMapping
    public List<UserDetails> getAllDetail() {
        return userDetailsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> getDetailById(@PathVariable Long id) {
        UserDetails details = userDetailsRepository.findById(id).orElse(null);
        if (details == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(details);
    }

    @PostMapping
    public UserDetails createDetails(@RequestBody UserDetails details) {
        return userDetailsRepository.save(details);
    }
}
