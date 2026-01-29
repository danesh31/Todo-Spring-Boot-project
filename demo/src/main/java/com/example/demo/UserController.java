package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    public UserController(UserRepository userRepo,PasswordEncoder passwordEncoder){
        this.userRepo=userRepo;
        this.passwordEncoder=passwordEncoder;
    }
    
@PostMapping("/register")
public ResponseEntity<?> register(@Valid @RequestBody @NonNull User user) {

    if (userRepo.existsByEmail(user.getEmail())) {
        return ResponseEntity
                .badRequest()
                .body("Email already registered");
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(user);
    return ResponseEntity.ok("Registered successfully");
}
@GetMapping("/me")
public User me(Authentication authentication) {

    if (authentication == null) {
        throw new RuntimeException("Not authenticated");
    }

    return userRepo
            .findByEmail(authentication.getName())
            .orElseThrow();
}


}
