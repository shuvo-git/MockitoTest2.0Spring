package com.jobayed.mockito_test.user.service;

import com.jobayed.mockito_test.user.dao.UserRepository;
import com.jobayed.mockito_test.user.model.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        User user = new User(110,"Momin Shah","admin");
        when(userRepository.save(user)).thenReturn(user);

        assertEquals(user,userService.saveUser(user));
    }

    @Test
    public void getAllUserTest() {
        when(userRepository.findAll()).thenReturn(Stream.of(
                new User(101,"Aman Ali","User"),
                new User(102,"Sadun Ali Halder","User"),
                new User(103,"Momin Ali","User")
        ).collect(Collectors.toList()));

        assertEquals(3,userService.getAllUser().size());
    }

    @Test
    public void deleteUserByIdTest() {
        User user = new User(110,"Momin Shah","admin");
        userService.deleteUserById(user.getId());

        verify(userRepository,times(1)).deleteById(user.getId());
    }
}