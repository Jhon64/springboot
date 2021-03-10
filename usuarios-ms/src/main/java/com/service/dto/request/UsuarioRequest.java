package com.service.dto.request;

public class UsuarioRequest {
	private String user;
	private String password;
	private int persona;
	private String rolId;

	public UsuarioRequest() {
	}

	public UsuarioRequest(String user, String password, int persona, String id) {
		this.user = user;
		this.password = password;
		this.persona = persona;
		this.rolId = id;
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

	public int getPersona() {
		return persona;
	}

	public void setPersona(int persona) {
		this.persona = persona;
	}

	public String getRolId() {
		return rolId;
	}

	
	@Override
	public String toString() {
		return "UsuarioRequest [user=" + user + ", password=" + password + ", persona=" + persona + ", rolId=" + rolId
				+ ", getUser()=" + getUser() + ", getPassword()=" + getPassword() + ", getPersona()=" + getPersona()
				+ ", getRolId()=" + getRolId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public void setRolId(String id) {
		this.rolId = id;
	}

}
