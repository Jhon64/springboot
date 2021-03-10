package com.service.service;


import java.util.List;



import com.service.bean.Usuario;
import com.service.dto.response.UsuarioResponse;


public interface UsuarioService {

	public List<UsuarioResponse> listar();
	public Usuario registrarUsuario(Usuario newUsuario);
	public Boolean existsByUser(String user);
	public Boolean existsByUserAndPassword(String user,String password);
	public Usuario findById(String id) throws Exception;
	public void deleteUser(String id);
	public void updateUser(Usuario userUpdate); 
}
