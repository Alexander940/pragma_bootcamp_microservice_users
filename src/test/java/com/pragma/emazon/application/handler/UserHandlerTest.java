package com.pragma.emazon.application.handler;

import com.pragma.emazon.application.dto.UserRequest;
import com.pragma.emazon.application.dto.UserResponse;
import com.pragma.emazon.application.mapper.UserRequestMapper;
import com.pragma.emazon.application.mapper.UserResponseMapper;
import com.pragma.emazon.domain.api.IUserServicePort;
import com.pragma.emazon.domain.model.Role;
import com.pragma.emazon.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserHandlerTest {

    private UserHandler userHandler;
    @Mock
    private IUserServicePort userServicePort;
    @Mock
    private UserRequestMapper userRequestMapper;
    @Mock
    private UserResponseMapper userResponseMapper;

    @BeforeEach
    void setUp() {
        try (AutoCloseable mocks = MockitoAnnotations.openMocks(this)) {
            userHandler = new UserHandler(userServicePort, userRequestMapper, userResponseMapper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void when_saveUser_method_is_called_with_an_UserRequest_and_returns_an_UserResponse() {
        UserRequest userRequest = new UserRequest("name", "lastname", "123321312", "+123123", Calendar.getInstance(), "admin@gmail.com", "password", 0, 0, "ADMIN");
        UserResponse userResponse = new UserResponse("name", "lastname", "123321312", "+123123", Calendar.getInstance(), "admin@gmail.com", "password", 0, 0, new Role(1L, "ADMIN", "description"));
        User user = new User.Builder()
                .name("name")
                .lastname("lastname")
                .documentID("123321312")
                .phone("+123123")
                .birthday(Calendar.getInstance())
                .email("fsadfasd")
                .build();

        when(userRequestMapper.toUser(userRequest)).thenReturn(user);
        when(userServicePort.saveuser(user)).thenReturn(user);
        when(userResponseMapper.toUserResponse(user)).thenReturn(userResponse);

        UserResponse userResponseResult = userHandler.saveUser(userRequest);

        assertEquals(userResponse, userResponseResult);
    }
}