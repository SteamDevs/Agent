package com.hck.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hck.app.models.entity.Users;
import com.hck.app.models.services.UServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class UsersController {
	
	@Autowired
	private UServiceImpl userService;
	
	@GetMapping("/users")
	public List<Users> index(){
		return userService.findAll();
	}
	
}
