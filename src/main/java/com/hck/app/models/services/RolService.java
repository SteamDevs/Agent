package com.hck.app.models.services;

import java.util.List;

import com.hck.app.models.entity.Rol;;

public interface RolService {
	
	//Only rol
	public List<Rol> findAll();
	
	public Rol save(Rol rol );
	
}
