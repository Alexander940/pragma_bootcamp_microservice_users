package com.pragma.emazon.infrastructure.out.jpa.mapper;

import com.pragma.emazon.domain.model.Role;
import com.pragma.emazon.domain.model.User;
import com.pragma.emazon.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    default User toUser(UserEntity userEntity){
        if (userEntity == null) return null;

        User.Builder builder = new User.Builder();

        builder.id(userEntity.getId())
                .name(userEntity.getName())
                .lastname(userEntity.getLastname())
                .documentID(userEntity.getDocumentID())
                .phone(userEntity.getPhone())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .role(new Role(userEntity.getRole().getId(), userEntity.getRole().getName(), userEntity.getRole().getDescription()))
                .birthday(userEntity.getBirthday())
                .disabled(userEntity.getDisabled())
                .locked(userEntity.getLocked());

        return builder.build();
    }

    UserEntity toEntity(User user);
}
