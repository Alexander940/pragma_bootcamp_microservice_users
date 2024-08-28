package com.pragma.emazon.domain.api;

import com.pragma.emazon.domain.model.User;

public interface IUserServicePort {
    User saveuser(User user);
}
