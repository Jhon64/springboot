package com.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.bean.Usuario;
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	public Boolean existsByUser(String user);
	public Boolean existsByUserAndPassword(String user, String password);
}
