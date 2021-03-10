package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.entity.Rol;
import com.service.repository.RolRepository;
import com.service.service.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private  RolRepository rolRepository;
	
	@Override
	public List<Rol> listar() {
		return rolRepository.findAll();
	}

	@Override
	public Rol registrar(Rol newRol) {
		return rolRepository.insert(newRol);
	}

	@Override
	public void eliminarID(String id) throws Exception {
		if (rolRepository.existsById(id)) {
			rolRepository.deleteById(id);
		}else {
			throw new Exception("id no válido");
			
		}
		
	}

	@Override
	public void actualizar(String id, Rol updateRol) {
		rolRepository.insert(updateRol);
		
	}

	@Override
	public Rol buscarById(String id) throws Exception {
			return rolRepository.findById(id).orElseThrow(()-> new Exception("No se encontro resultado"));

	}

	@Override
	public Boolean verificarExitente(String nombre, String codigo) {
		 List<Rol> list=rolRepository.findByNombreAndCodigo(nombre, codigo);
		 if(list.size()>0)return false;
		 else return true;
		 
	}

	@Override
	public Boolean existsById(String id) {
		return rolRepository.existsById(id);
	}

}
