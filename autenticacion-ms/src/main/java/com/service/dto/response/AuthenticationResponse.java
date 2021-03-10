package com.service.dto.response;

public class AuthenticationResponse {

	private String token;	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthenticationResponse() {
	}

	public AuthenticationResponse(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [token=" + token + "]";
	}
	
	
	
	
}
