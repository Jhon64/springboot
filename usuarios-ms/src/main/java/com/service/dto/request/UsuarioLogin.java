package com.service.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioLogin {
	@NotNull
	@NotEmpty
	@Size(min = 3)
	public String user;
	@NotNull
	@NotEmpty
	@Size(min = 5)
	public String password;
}
