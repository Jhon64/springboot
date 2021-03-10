package com.service.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;


@Document(collection="rol")
public class Rol {
	@Id
	private String _id;

	@Indexed(unique = true)
	@NonNull
	private String nombre;
	
	@Indexed(unique = true)
	@NonNull
	private String codigo;
	
	@Field
	@Nullable
	private String descripcion;
	@DateTimeFormat(iso =DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "dd-mm-yyyy hh:mm a")
	private Date fechaRegistro=new Date();
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@JsonFormat(pattern = "dd-mm-yyyy hh:mm a")
	private Date fechaUpdate=new Date();
	
	public Rol() {	}
	
	public Rol(String _id, String nombre, String codigo, String descripcion) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaRegistro = new Date();
		this.fechaUpdate =new Date();
	}
	public Rol(String _id, String nombre, String codigo, String descripcion,Date fechaUpdate) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaUpdate =fechaUpdate;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaUpdate() {
		return fechaUpdate;
	}
	public void setFechaUpdate(Date fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}
	

}
