package com.service.controllers;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.configuration.CustomerUserDetailsService;
import com.service.configuration.JWTTokenUtil;
import com.service.dto.request.AuthenticationRequest;
import com.service.dto.response.AuthenticationResponse;;

@RestController
public class AutenticacionController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomerUserDetailsService userDetailsService;
	@Autowired
	private JWTTokenUtil jwtTokenUtil;
	
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody 
			AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUser(),
							authenticationRequest.getPassword()));
		}catch(DisabledException e) {
			throw new Exception("USER_DISABLED",e);
		}catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALES",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUser());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token));
	
	}
	
	@PostMapping("/user/auth")
	public String autenticacion(@RequestBody AuthenticationRequest user) {
		String jwt=this.JWTGenerate(user.getUser());
		System.out.print(jwt);
		return jwt;
	}
	
	public String JWTGenerate(String username) {
		String _secretKEY="secret";
		
		return _secretKEY;
	}
}
