package com.weighttracker.app.application.user.dto;

public record SignUpRequest(
		
	    String username,
	    
	    String email,
	    
	    String password,
	    
	    String firstName,
	    
	    String lastName
	) {}