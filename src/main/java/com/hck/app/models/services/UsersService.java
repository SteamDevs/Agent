package com.hck.app.models.services;

import java.util.List;

import com.hck.app.models.entity.Users;

public interface UsersService {
	
	public List<Users> findAll();
	
	public Users findById(Long id );
	
	public Users save(Users users);
	
	public void delete(Long id );
	
	public Users verifyLogin(Users user );
}
