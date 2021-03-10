package com.service.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.dto.request.UserAuth;

@RestController
public class AutenticacionController {

	@PostMapping("/user/auth")
	public String autenticacion(@RequestBody UserAuth user) {
		String jwt=this.JWTGenerate(user.getUser());
		System.out.print(jwt);
		return jwt;
	}
	
	public String JWTGenerate(String username) {
		String _secretKEY="secret";
		
		return _secretKEY;
	}
}
