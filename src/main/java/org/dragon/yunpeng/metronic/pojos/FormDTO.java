package org.dragon.yunpeng.metronic.pojos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class FormDTO {
	@NotEmpty(message = "Username is required")
	private String username;

	@NotEmpty(message = "Email is required")
	@Email(message = "Valid email is required")
	private String email;

	// Getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
