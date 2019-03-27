package com.hck.app.models.services;

import java.util.List;

import com.hck.app.models.entity.Users;

public interface UsersService {
	
	public List<Users> findAll();
	
	public Users findById(Long id );
	
	public Users save(Users users);
	
	public void delete(Long id );
	
	//Get Data Users For Token
	public Users findByUsername(String username );
	
	//Deprecated
	//public Users verifyLogin(Users user );
	
	
	
}
