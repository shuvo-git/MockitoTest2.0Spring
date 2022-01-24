package com.jobayed.mockito_test.user.service;

import com.jobayed.mockito_test.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User saveUser(User user);
    List<User> getAllUser();
    void deleteUserById(int id);
}
