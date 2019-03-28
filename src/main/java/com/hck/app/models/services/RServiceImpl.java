package com.hck.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hck.app.models.dao.RolRepository;
import com.hck.app.models.entity.Rol;

@Service
public class RServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rolDao;
	
	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Rol>) rolDao.findAll(); 
	}

	@Override
	public Rol save(Rol rol) {
		// TODO Auto-generated method stub
		return rolDao.save(rol);
	}

}
