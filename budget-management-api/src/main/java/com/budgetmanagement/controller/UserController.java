package com.budgetmanagement.controller;

import com.budgetmanagement.entity.User;
import com.budgetmanagement.service.JwtService;
import com.budgetmanagement.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for managing user authentication and registration.
 * Provides endpoints for user registration and login.
 */
@RestController
@RequestMapping("/users") // Base URL for user-related operations
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Constructor to inject dependencies.
     *
     * @param userService            Service for user management.
     * @param passwordEncoder        Password encoder for hashing passwords.
     * @param jwtService             Service for JWT token generation.
     * @param authenticationManager  Spring Security authentication manager.
     */
    public UserController(UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Registers a new user.
     *
     * @param user User details received in the request body.
     * @return A response message confirming successful registration.
     */
    @PostMapping("/register")
    public Map<String, String> registerUser(@RequestBody User user) {
        // Hash the password before storing
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user in the database
        userService.createUser(user);

        // Return success message
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        return response;
    }

    /**
     * Authenticates a user and generates a JWT token.
     *
     * @param loginRequest User login credentials received in the request body.
     * @return A JWT token if authentication is successful.
     */
    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody User loginRequest) {
        // Authenticate the user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Load user details from database
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());

        // Generate JWT token
        String token = jwtService.generateToken(userDetails);

        // Return the token as response
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }
}
