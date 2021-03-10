package com.service.servicempl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.service.bean.Usuario;
import com.service.clients.RolClient;
import com.service.dominio.Rol;
import com.service.dto.response.RolResponse;
import com.service.dto.response.UsuarioResponse;
import com.service.repository.UsuarioRepository;
import com.service.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RolClient rolClient;
	
	@Override
	public List<UsuarioResponse> listar() {
		
		List<Usuario> list= usuarioRepository.findAll();
		ModelMapper model=new ModelMapper();
		List<UsuarioResponse> listResponse=new ArrayList<UsuarioResponse>();
		list.forEach((item)->{
			//RolDominio rolDominio=rolClient.buscarById(item.getRol().get_id());
			//System.out.print(rolDominio);
			UsuarioResponse usuarioResponse=model.map(item, UsuarioResponse.class);
			//System.out.print(item.getRol().getNombre());
			usuarioResponse.setIndex(list.lastIndexOf(item));
			RolResponse rolResponse=model.map(item.getRol(), RolResponse.class);
			usuarioResponse.setRol(rolResponse);
			listResponse.add(usuarioResponse);
		});
	
		return listResponse;
		
	}

	@Override
	public Usuario registrarUsuario(Usuario newUsuario) {
		return usuarioRepository.insert(newUsuario);
	}

	@Override
	public Boolean existsByUser(String user) {
		return usuarioRepository.existsByUser(user);
	}
	
	@Override
	public Usuario findById(String id) throws Exception {
		return usuarioRepository.findById(id).orElseThrow(()-> new Exception("no se encontró usuario"));
	}

	@Override
	public Boolean existsByUserAndPassword(String user, String password) {
		return usuarioRepository.existsByUserAndPassword(user, password);
	}

	@Override
	public void deleteUser(String id) {
		usuarioRepository.deleteById(id);
		
	}

	@Override
	public void updateUser(Usuario userUpdate) {
		usuarioRepository.save(userUpdate);
		
	}

	

}
