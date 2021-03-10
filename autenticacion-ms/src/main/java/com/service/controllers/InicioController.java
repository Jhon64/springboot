package com.service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {
	@GetMapping("/acceso")
	public String greeting() {
		return "service acceso-ms";
	}
}
