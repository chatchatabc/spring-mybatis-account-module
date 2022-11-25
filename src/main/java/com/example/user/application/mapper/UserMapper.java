package com.example.user.application.mapper;

import com.example.user.application.dto.UserRegisDto;
import com.example.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRegisDto modelToDto(User user);

    User dtoToModel(UserRegisDto userRegisDto);
}
