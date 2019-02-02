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

	@Override
	@Transactional(readOnly = true )
	public Users findById(Long id) {
		// TODO Auto-generated method stub
		return usersDao.findById(id)
				.orElse(null);
	}

	@Override
	@Transactional
	public Users save(Users users) {
		// TODO Auto-generated method stub
		return usersDao.save(users);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usersDao.deleteById(id);
	}

}
