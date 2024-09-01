package com.pragma.emazon.application.handler;

import com.pragma.emazon.application.dto.UserRequest;
import com.pragma.emazon.application.dto.UserResponse;
import com.pragma.emazon.application.mapper.UserRequestMapper;
import com.pragma.emazon.application.mapper.UserResponseMapper;
import com.pragma.emazon.domain.api.IUserServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler{

    private final IUserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        return userResponseMapper.toUserResponse(userServicePort.saveuser(userRequestMapper.toUser(userRequest)));
    }
}
