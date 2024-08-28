package com.pragma.emazon.application.mapper;

import com.pragma.emazon.application.dto.UserResponse;
import com.pragma.emazon.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {

    UserResponse toUserResponse(User user);
}
