package com.service.dominio;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Document(collection="rol")
public class Rol {

	private String _id;
	private String nombre;
	private String codigo;
	private String descripcion;
	@DateTimeFormat(iso =DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "dd-mm-yyyy hh:mm a")
	private Date fechaRegistro=new Date();
	@DateTimeFormat(iso =DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "dd-mm-yyyy hh:mm a")
	private Date fechaUpdate=new Date();
	
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
	@Override
	public String toString() {
		return "Rol [_id=" + _id + ", nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", fechaRegistro=" + fechaRegistro + ", fechaUpdate=" + fechaUpdate + "]";
	}
	
	
}
