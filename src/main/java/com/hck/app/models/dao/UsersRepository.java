package com.hck.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hck.app.models.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
	
	//Using JPQL
	@Query("SELECT users FROM Users u WHERE u.nick=?1")
	public Users findByNick(String nick ); 
}
