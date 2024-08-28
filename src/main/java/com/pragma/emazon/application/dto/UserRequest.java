package com.pragma.emazon.application.dto;

import jakarta.validation.constraints.Size;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Calendar;

public record UserRequest(
        @NonNull
        String name,
        @NonNull
        String lastname,
        @NonNull
        String documentID,
        @NonNull
        @Size(max = 13)
        String phone,
        @NonNull
        Calendar birthday,
        @NonNull
        String email,
        @NonNull
        String password,
        Integer locked,
        Integer disabled,
        @NonNull
        String roleName
) implements Serializable {
}
