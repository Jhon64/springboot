package com.service.controllersImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.entity.Rol;
import com.service.service.RolService;

@RestController
public class RolControllerImpl {

	@Autowired
	private RolService rolService;

	@GetMapping("/api/rol/listar")
	public List<Rol> listar() {
		return rolService.listar();
	}

	@PostMapping("/api/rol/registrar")
	public ResponseEntity<?> registrar(@RequestBody Rol newRol) {
		try {
			boolean isNullCodigo = newRol.getCodigo().trim().isEmpty();
			boolean isNullNombre = newRol.getNombre().trim().isEmpty();
			if (isNullCodigo)
				throw new Exception("código es obligatorio");
			if (isNullNombre)
				throw new Exception("nombre es obligatorio");
			if (!isNullCodigo && !isNullNombre) {
				if (rolService.verificarExitente(newRol.getNombre(), newRol.getCodigo())) {
					Rol savedRol = rolService.registrar(newRol);
					return new ResponseEntity<>(savedRol, HttpStatus.OK);
				} else
					throw new Exception("la información ya se ha registrado ");

			} else
				return new ResponseEntity<>(newRol, HttpStatus.BAD_REQUEST);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@GetMapping("/api/rol/existe/{id}")
	public Boolean existeId(@PathVariable String id) {
		return rolService.existsById(id);
	}
	
	@GetMapping("/api/rol/buscar/{id}")
	public ResponseEntity<?> buscarById(@PathVariable String id) {
		try {
			Rol searchRol=rolService.buscarById(id);
			return new ResponseEntity<>(searchRol,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	@DeleteMapping("/api/rol/eliminar/{id}")
	public ResponseEntity<?> eliminarRol(@PathVariable String id)  {
		try {
			rolService.eliminarID(id);	
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	}
}
