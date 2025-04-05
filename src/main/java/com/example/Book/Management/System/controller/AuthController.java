package com.example.Book.Management.System.controller;

import com.example.Book.Management.System.config.JwtUtil;
import com.example.Book.Management.System.dto.AuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager; //Use the AuthenticationManager to authenticate the credentials.
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authRequest){
        try {
            //1. Authenticate the credentials using the authentication manager
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            //2. If authentication is successful, generate a JWT token
            String token = jwtUtil.generateToken(authRequest.getUsername());

            //3. Return the token as part of the response
            return ResponseEntity.ok(token);
        }catch (Exception e){
            //If auth fails, return an error response
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }
}
