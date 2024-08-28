package com.pragma.emazon.infrastructure.input.rest;

import com.pragma.emazon.application.dto.UserRequest;
import com.pragma.emazon.application.dto.UserResponse;
import com.pragma.emazon.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @Operation(summary = "Add a new User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "400", description = "User name or description too long", content = @Content),
            @ApiResponse(responseCode = "400", description = "User already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<UserResponse> saveCategory(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userHandler.saveUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}
