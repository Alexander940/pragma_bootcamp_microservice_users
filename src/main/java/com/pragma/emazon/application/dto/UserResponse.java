package com.pragma.emazon.application.dto;

import com.pragma.emazon.domain.model.Role;

import java.io.Serializable;
import java.util.Calendar;

public record UserResponse(
        String name,
        String lastname,
        String documentID,
        String phone,
        Calendar birthday,
        String email,
        String password,
        Integer locked,
        Integer disabled,
        Role role
) implements Serializable {
}
