package com.budgetmanagement;

import com.budgetmanagement.entity.User;
import com.budgetmanagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Integration test for UserController.
 * Ensures user registration API functions correctly.
 */
@SpringBootTest
@AutoConfigureMockMvc // Enables MockMvc for testing controllers
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc; // Simulates HTTP requests

    @Autowired
    private ObjectMapper objectMapper; // Converts objects to JSON

    @Autowired
    private UserService userService; // User service to interact with database

    /**
     * Setup method executed before each test.
     * Creates a test user in the database.
     */
    @BeforeEach
    void setup() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        user.setRole("USER");

        userService.createUser(user); // Persist test user
    }

    /**
     * Tests user registration API.
     * Sends a POST request with user data and expects a success message.
     */
    @Test
    void testUserRegistration() throws Exception {
        // Create new user object
        User user = new User();
        user.setUsername("newuser");
        user.setPassword("password");
        user.setRole("USER");

        // Perform POST request to register user
        mockMvc.perform(post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))) // Convert user to JSON
                .andExpect(status().isOk()) // Expect HTTP 200 response
                .andExpect(jsonPath("$.message").value("User registered successfully")); // Verify response message
    }
}
