package com.weighttracker.app.domain.user.model;

public class Password {
	
	private final String value;

	public Password(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password must not be empty");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
