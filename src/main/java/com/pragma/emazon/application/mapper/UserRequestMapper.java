package com.pragma.emazon.application.mapper;

import com.pragma.emazon.application.dto.UserRequest;
import com.pragma.emazon.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {

    User toUser(UserRequest userRequest);
}
