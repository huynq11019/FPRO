package com.fpro.iam.application.mapper;

import com.fpro.iam.domain.User;
import com.fpro.iam.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<User, UserEntity> {
}
