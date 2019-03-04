package com.hck.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hck.app.models.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
	
	//Using JPQL
	@Query("select u from Users u where u.username=?1")
	public Users findByUsername(String username);
}
