package com.Vishal.BlogApp.Service;

import java.util.List;

import com.Vishal.BlogApp.Payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUser();
	void deleteUser(Integer userId);

}
