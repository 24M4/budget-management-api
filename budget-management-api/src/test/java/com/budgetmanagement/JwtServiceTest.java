package com.budgetmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.budgetmanagement.service.JwtService;

import static org.junit.jupiter.api.Assertions.*;



/**
 * Unit test for JwtService.
 */
class JwtServiceTest {

    private final JwtService jwtService = new JwtService();

    /**
     * Tests token generation.
     */
    @Test
    void testGenerateToken() {
        UserDetails userDetails = User.withUsername("testuser")
                .password("password")
                .roles("USER")
                .build();

        String token = jwtService.generateToken(userDetails);
        assertNotNull(token);
    }

    /**
     * Tests token validation.
     */
    @Test
    void testValidateToken() {
        UserDetails userDetails = User.withUsername("testuser")
                .password("password")
                .roles("USER")
                .build();

        String token = jwtService.generateToken(userDetails);
        assertTrue(jwtService.validateToken(token, userDetails));
    }
}
