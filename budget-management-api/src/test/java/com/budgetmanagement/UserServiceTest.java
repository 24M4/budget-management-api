package com.budgetmanagement;

import com.budgetmanagement.entity.User;
import com.budgetmanagement.repository.UserRepository;
import com.budgetmanagement.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 * Unit test for UserService.
 */
class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    /**
     * Sets up mock dependencies before each test.
     */
    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        userService = new UserService(userRepository, passwordEncoder);
    }

    /**
     * Tests user registration with password hashing.
     */
    @Test
    void testCreateUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        user.setRole("USER");

        when(passwordEncoder.encode("password")).thenReturn("hashedpassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.createUser(user);
        
        assertNotNull(savedUser);
        assertEquals("hashedpassword", savedUser.getPassword());
        verify(userRepository, times(1)).save(any(User.class));
    }
}
