package com.service.bean;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.service.dominio.Rol;

@Document(collection = "usuario")
public class Usuario {
	@Id
	private String _id;
	@Field
	@Indexed(unique = true)
	@NotNull
	private String user;
	@Field
	@NotNull
	private String password;
	@Field
	@NotNull
	private int persona;

	@DBRef
	private Rol rol;
	
	

	public Usuario() {
	}

	public Usuario(String id, String user, String password, int persona, Rol rol) {
		super();
		this._id = id;
		this.user = user;
		this.password = password;
		this.persona = persona;
		this.rol = rol;
	}

	public String get_Id() {
		return _id;
	}

	public void set_Id(String id) {
		this._id = id;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [_id=" + _id + ", user=" + user + ", password=" + password + ", persona=" + persona + ", rol="
				+ rol + "]";
	}

}
