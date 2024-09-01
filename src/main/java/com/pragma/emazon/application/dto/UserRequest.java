package com.pragma.emazon.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
