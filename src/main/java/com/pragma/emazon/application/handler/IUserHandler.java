package com.pragma.emazon.application.handler;

import com.pragma.emazon.application.dto.UserRequest;
import com.pragma.emazon.application.dto.UserResponse;
import com.pragma.emazon.domain.model.User;

public interface IUserHandler {
    UserResponse saveUser(UserRequest userRequest);
}
