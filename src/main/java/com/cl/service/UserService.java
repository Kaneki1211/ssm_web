package com.cl.service;

import com.cl.domain.User;

public interface UserService {

    boolean userRegister(User user);
    boolean userLogin(User user);
}
