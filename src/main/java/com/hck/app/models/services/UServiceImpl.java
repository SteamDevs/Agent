package com.hck.app.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hck.app.models.dao.UsersRepository;
import com.hck.app.models.entity.Users;

@Service
public class UServiceImpl implements  UserDetailsService  {
		
	@Autowired
	private UsersRepository usersDao;
	
	//Login Method
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users usuario = usersDao.findByUsername(username);
		
		if(usuario == null ) {
			System.out.println("El usuario no existe :( ");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map( rol -> new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toList());  //Convert Stream to List user.rol
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}
	
}
