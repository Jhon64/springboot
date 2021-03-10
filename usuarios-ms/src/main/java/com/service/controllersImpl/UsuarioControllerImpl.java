package com.service.controllersImpl;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.bean.Usuario;
import com.service.clients.RolClient;
import com.service.dominio.Rol;
import com.service.dto.request.UsuarioLogin;
import com.service.dto.request.UsuarioRequest;
import com.service.dto.response.UsuarioResponse;
import com.service.service.UsuarioService;

@RestController
public class UsuarioControllerImpl {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RolClient rolClient;

	@GetMapping("/api/usuario/listar")
	public List<UsuarioResponse> listar() {
		return usuarioService.listar();
	}

	@GetMapping("/existe/rol/{id}")
	public Boolean existeRol(@PathVariable String id) {
		return rolClient.existeRolById(id);
	}

	@PostMapping("/api/usuario/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
		try {
			String id = usuarioRequest.getRolId();
			String user = usuarioRequest.getUser();
			String password = usuarioRequest.getPassword();
			int personaId = usuarioRequest.getPersona();
			System.out.print(personaId);
			if (id != null && user != null && password != null && personaId != 0) {
				if (rolClient.existeRolById(id)) {
					if (!usuarioService.existsByUser(usuarioRequest.getUser())) {
						if (user.isEmpty() || password.isEmpty())
							return new ResponseEntity<>("los campos no deben ser vacios", HttpStatus.BAD_REQUEST);
						Rol searchRol = rolClient.buscarById(id);
						ModelMapper mapper = new ModelMapper();
						Usuario newUsuario = mapper.map(usuarioRequest, Usuario.class);
						newUsuario.setRol(searchRol);
						// System.out.print(searchRol.toString());
						Usuario savedUsuario = usuarioService.registrarUsuario(newUsuario);
						return new ResponseEntity<>(savedUsuario, HttpStatus.OK);
					} else
						return new ResponseEntity<>("usuario ya se encuentra registrado",
								HttpStatus.INTERNAL_SERVER_ERROR);

				} else
					return new ResponseEntity<>("rol no existe", HttpStatus.INTERNAL_SERVER_ERROR);
			} else
				return new ResponseEntity<>("campos enviados incorrectos", HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/api/exists/user/{user}")
	public Boolean existsByUser(@PathVariable String user) {
		return usuarioService.existsByUser(user);
	}

	@GetMapping("/api/usuario/buscar/id/{id}")
	public Usuario findById(@PathVariable String id) throws Exception {
		return usuarioService.findById(id);
	}

	@PostMapping("/api/login")
	public Boolean login(@RequestBody UsuarioLogin usuarioLogin) {
		return usuarioService.existsByUserAndPassword(usuarioLogin.user, usuarioLogin.password);
	}

	@GetMapping("/api/roles/listar")
	public List<Rol> listarRoles() {
		return rolClient.getListRoles();
	}

	@DeleteMapping("/api/usuario/eliminar/{id}")
	public void deleteUser(@PathVariable String id) {
		usuarioService.deleteUser(id);
	}

	@PutMapping("/api/usuario/update/{id}")
	public void updateUser(@PathVariable String id, @RequestBody UsuarioRequest updateUsuario) throws Exception {
		Usuario searchUser = usuarioService.findById(id);
		 //System.out.print(updateUsuario.toString());
		ModelMapper model = new ModelMapper();
		Usuario userUpdate = model.map(searchUser, Usuario.class);
		if(updateUsuario.getUser()!=null)userUpdate.setUser(updateUsuario.getUser());
		if(updateUsuario.getPassword()!=null)userUpdate.setPassword(updateUsuario.getPassword());
		if(updateUsuario.getRolId()!=null) {
			Rol rol = rolClient.buscarById(updateUsuario.getRolId());
			userUpdate.setRol(rol);
		}
		if(updateUsuario.getPersona()!=0)userUpdate.setPersona(updateUsuario.getPersona());
		System.out.print(userUpdate.toString());
		usuarioService.updateUser(userUpdate);
	}

}
