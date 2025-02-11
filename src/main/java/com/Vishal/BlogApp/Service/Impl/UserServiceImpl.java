package com.Vishal.BlogApp.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vishal.BlogApp.Entities.User;
import com.Vishal.BlogApp.Payloads.UserDto;
import com.Vishal.BlogApp.Service.UserService;
import com.Vishal.BlogApp.Repositories.*;
import com.Vishal.BlogApp.Entities.*;
import com.Vishal.BlogApp.exceptions.*;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private  UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
//	public UserServiceImpl(UserRepo userRepo) {
//	    this.userRepo = userRepo;
//	}


	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User"," Id ",userId));
		
		user.setName(userDto.getName());                                                                                                                                                                   
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(user.getAbout());
		 
		User updateUser=this.userRepo.save(user);
		UserDto userDto1=this.userToDto(updateUser);
		return userDto1;
		
		
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto,User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		
		
		return user;
		
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	

}
