package com.service.configuration;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JWTTokenUtil {

	private String secret="secret";
	private int jwtExpirationDateInMs=18000000;
	
	
	public String get_key() {
		return secret;
	}
	
	//@Value("${jwt.secret}")
	public void set_key(String _key) {
		this.secret = _key;
	}
	public int getJwtExpirationInMs() {
		return jwtExpirationDateInMs;
	}
	
	//@Value("${jwt.jwtExpirationDateInMs}")
	public void setJwtExpirationInMs(int jwtExpirationDateInMs) {
		this.jwtExpirationDateInMs = jwtExpirationDateInMs;
	}
	
	//generar token para usuario
	public String generateToken(UserDetails userDetails) {
		System.out.print(userDetails);
		Map<String, Object> claims=new HashMap<>();
		Collection<? extends GrantedAuthority> roles=userDetails.getAuthorities();
		if(roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
			claims.put("isAdmin", true);
		if(roles.contains(new SimpleGrantedAuthority("ROLE_USER")))
			claims.put("isAdmin", true);
		return this.doGenerateToken(claims, userDetails.getUsername());
	}
	
	private String doGenerateToken(Map<String,Object> claims,String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+jwtExpirationDateInMs))
				.signWith(SignatureAlgorithm.HS512, this.secret)
				.compact();
	}
	
	
	
}
