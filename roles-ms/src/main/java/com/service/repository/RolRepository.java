package com.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.entity.Rol;

@Repository
public interface RolRepository extends MongoRepository<Rol, String>{

	public List<Rol> findByNombreAndCodigo(String nombre,String codigo);
	public void deleteById(String id);
	
}
