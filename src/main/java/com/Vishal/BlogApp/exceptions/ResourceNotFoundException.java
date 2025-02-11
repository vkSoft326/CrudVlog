package com.Vishal.BlogApp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException{
  String resourcename;
  String feildname;
  long feildValue;
  
  public ResourceNotFoundException(String resourcename, String fieldName, long fieldValue) {
	  
	super(String.format("%s not found with %s :  %s", resourcename,fieldName,fieldValue));
	this.resourcename = resourcename;
	this.feildname = feildname;
	this.feildValue = feildValue;
}
}
