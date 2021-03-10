package com.service.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

	private String user;
	private String password;
	
	
	
	public AuthenticationRequest(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	public AuthenticationRequest() {
		
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserAuth [user=" + user + ", password=" + password + "]";
	}
	
}
