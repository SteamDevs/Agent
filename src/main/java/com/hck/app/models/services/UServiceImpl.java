package com.hck.app.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hck.app.models.dao.UsersRepository;
import com.hck.app.models.entity.Users;

@Service
public class UServiceImpl implements UsersService  {
	
	@Autowired
	private UsersRepository usersDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Users> findAll() {
		return (List<Users>) usersDao.findAll();
	}

}
