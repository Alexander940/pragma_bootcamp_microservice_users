package com.pragma.emazon.domain.spi;

import com.pragma.emazon.domain.model.User;

public interface IUserPersistencePort {
    User saveUser(User user);
}
