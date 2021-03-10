package com.service.service;

import java.util.List;

import com.service.entity.Rol;

public interface RolService {
	public List<Rol> listar();
	public Rol registrar(Rol newRol);
	public void eliminarID(String id) throws Exception;
	public void actualizar(String id,Rol updateRol);
	public Rol buscarById(String id) throws Exception;
	public Boolean verificarExitente(String nombre,String descripcion);
	public Boolean existsById(String id);
}
