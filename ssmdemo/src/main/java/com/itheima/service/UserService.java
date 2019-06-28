package com.itheima.service;

import com.itheima.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User login(User user);
}
