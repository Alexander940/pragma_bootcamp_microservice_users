package com.pragma.emazon.application.dto;

import java.io.Serializable;
import java.util.Calendar;

public record UserResponse(
        String name,
        String lastname,
        String documentID,
        String phone,
        String email,
        Calendar birthday,
        Integer locked,
        Integer disabled,
        String roleName
) implements Serializable {
}
