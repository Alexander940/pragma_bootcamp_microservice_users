package com.pragma.emazon.application.mapper;

import com.pragma.emazon.application.dto.UserRequest;
import com.pragma.emazon.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {

    default User toUser(UserRequest userRequest){
        if (userRequest == null) return null;

        User.Builder builder = new User.Builder();

        builder.name(userRequest.name())
                .lastname(userRequest.lastname())
                .documentID(userRequest.documentID())
                .phone(userRequest.phone())
                .email(userRequest.email())
                .password(userRequest.password())
                .roleName(userRequest.roleName())
                .birthday(userRequest.birthday())
                .disabled(userRequest.disabled())
                .locked(userRequest.locked());

        return builder.build();
    }
}
