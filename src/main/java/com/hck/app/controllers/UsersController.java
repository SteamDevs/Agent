package com.hck.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hck.app.models.entity.Users;
import com.hck.app.models.services.UServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200"}) //CorsConfig
@RestController
@RequestMapping("/api/v1")
public class UsersController {
	
	private static final  Logger log = LoggerFactory.getLogger( UsersController.class);
	
	@Autowired
	private UServiceImpl userService;
	
	@GetMapping("/users")
	public List<Users> index(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Users showUserById(@PathVariable Long id ) {
		if(id == null || id <= 0 ) {
			log.info("el id no es valido");
		}
		
		return userService.findById(id);
	}
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public Users addUser(@RequestBody Users users) {
		return  userService.save(users);
	}
	
	@PutMapping("/users/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Users updateUser(@RequestBody Users users, @PathVariable Long id ) {
		Users userActual = userService.findById(id);
		
		userActual.setPass(users.getPass());
		userActual.setNick(users.getNick());
		
		return userService.save(userActual);
	}
	
	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long id ) {
		userService.delete(id);
	}
	
	//Login Method
	@PostMapping("/users/login")
	@ResponseStatus(HttpStatus.CONTINUE)
	public Users loginUser(@RequestBody Users users ) {
		
		return userService.verifyLogin(users);
	}
	
		
}
