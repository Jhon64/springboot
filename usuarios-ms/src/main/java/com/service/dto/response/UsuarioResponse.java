package com.service.dto.response;

public class UsuarioResponse {
	private int index;
	private String id;
	private String user;
	private String password;
	private int persona;
	private RolResponse rol;
	
	
	
	public UsuarioResponse() {
	
	}
	public UsuarioResponse(int index, String id, String user, String password, RolResponse rol, int personaId) {
		super();
		this.index = index;
		this.id = id;
		this.user = user;
		this.password = password;
		this.rol = rol;
		this.persona= personaId;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public RolResponse getRol() {
		return rol;
	}
	public void setRol(RolResponse rol) {
		this.rol = rol;
	}
	public int getPersona() {
		return persona;
	}
	public void setPersona(int personaId) {
		this.persona = personaId;
	}
	
	
}
