package com.pragma.emazon.infrastructure.configuration;

import com.pragma.emazon.domain.api.IUserServicePort;
import com.pragma.emazon.domain.spi.IUserPersistencePort;
import com.pragma.emazon.domain.usecase.UserUseCase;
import com.pragma.emazon.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.pragma.emazon.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.pragma.emazon.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }
}
