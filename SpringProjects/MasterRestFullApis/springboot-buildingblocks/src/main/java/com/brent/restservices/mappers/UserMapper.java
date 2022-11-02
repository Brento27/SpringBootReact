package com.brent.restservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.brent.restservices.dtos.UserMsDto;
import com.brent.restservices.entities.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mappings({
		@Mapping(source = "email", target = "emailaddress"),
		@Mapping(source = "role", target = "rolename")
	})
	UserMsDto userToUserMsDto(User user);
	
	//List<User> to List<UserMsDto>
	List<UserMsDto> usersToUserDtos(List<User> users);

}