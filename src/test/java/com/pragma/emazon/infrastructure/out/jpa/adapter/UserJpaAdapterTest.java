package com.pragma.emazon.infrastructure.out.jpa.adapter;

import com.pragma.emazon.domain.model.User;
import com.pragma.emazon.infrastructure.out.jpa.entity.RoleEntity;
import com.pragma.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.emazon.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.pragma.emazon.infrastructure.out.jpa.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserJpaAdapterTest {

    private UserJpaAdapter userJpaAdapter;
    @Mock
    private IUserRepository userRepository;
    @Mock
    private UserEntityMapper userEntityMapper;

    @BeforeEach
    void setUp() {
        try (AutoCloseable mocks = MockitoAnnotations.openMocks(this)) {
            userJpaAdapter = new UserJpaAdapter(userRepository, userEntityMapper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void when_saveUser_method_and_returns_a_User() {
        // Given
        User.Builder builder = new User.Builder();
        builder.name("username")
                .password("password")
                .email("email")
                .roleName("ADMIN")
                .locked(0)
                .disabled(1);
        User user = builder.build();
        UserEntity userEntity = new UserEntity(1L, "username", "password", "102012301320", "12345678901", Calendar.getInstance(), "admin@gmail.com", "password", 0, 0, new RoleEntity());

        // When
        when(userEntityMapper.toEntity(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);

        User userResponse = userJpaAdapter.saveUser(user);

        // Then
        assertEquals(user, userResponse);
    }
}