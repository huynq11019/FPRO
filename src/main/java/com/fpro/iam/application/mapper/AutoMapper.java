package com.fpro.iam.application.mapper;

import com.fpro.iam.application.dto.request.UserCreateRequest;
import com.fpro.iam.domain.command.UserCreateCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutoMapper {

    UserCreateCmd userCreateCmd(UserCreateRequest userCreateRequest);
}
