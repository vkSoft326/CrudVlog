package com.Vishal.BlogApp.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	
	private int id;
	
	@NotEmpty
	@Size(min=4,message="UserName must be greater then 4 charcaters")
	private String name;
	
	@Email(message="your email add is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=4,max=10,message="password must be minium 3 chars and max 10 chars !!")
	
	private String password;
	
	@NotEmpty
	private String about;
	
}
