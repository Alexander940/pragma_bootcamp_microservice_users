package com.pragma.emazon.infrastructure.out.jpa.adapter;

import com.pragma.emazon.domain.model.User;
import com.pragma.emazon.domain.spi.IUserPersistencePort;
import com.pragma.emazon.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.emazon.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.pragma.emazon.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);

        return userEntityMapper.toUser(userRepository.save(userEntity));
    }
}
