package com.service.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.dominio.Rol;

@FeignClient("roles-ms")
public interface RolClient {

	@RequestMapping(method = RequestMethod.GET,value="/api/rol/listar")
	public List<Rol> getListRoles();
	
	@RequestMapping(method = RequestMethod.GET,value = "/api/rol/buscar/{id}")
	public Rol buscarById(@PathVariable String id);
	
	@RequestMapping(method = RequestMethod.GET,value = "/api/rol/existe/{id}")
	public Boolean existeRolById(@PathVariable String id);
	
}
