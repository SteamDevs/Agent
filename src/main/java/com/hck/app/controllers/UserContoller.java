package com.hck.app.controllers;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hck.app.models.entity.Users;
import com.hck.app.models.services.UServiceImpl;

@CrossOrigin(origins = { "http://localhost:4200/#/**" })
@RestController
@RequestMapping("/api/v1")
public class UserContoller {
	
	@Autowired
	private UServiceImpl userService; 
	 
	@GetMapping("/users")
	public List<Users> index(){
		
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> showOneUser(@PathVariable Long id ){
		
		Users users = null;
		
		try {
			users = userService.findById(id); 
		}catch(DataAccessException e) {
			return new ResponseEntity<>("{ \"message\" : \"DB Errors\"}"
					.concat(e.getMostSpecificCause().getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(users == null ) {
			return new ResponseEntity<>("{ \"message\" : \"el id no existe en la DB\"}",
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> storedUser(@RequestBody Users user ){
		Users newUsers = null;
		
		try {
			newUsers = userService.save(user);
		}catch(DataAccessException e) {
			return new ResponseEntity<>("{ \"message\" : \"DB Errors\"}"
					.concat(e.getMostSpecificCause().getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Users>(newUsers, HttpStatus.CREATED );
	}
	    
	@PostMapping("/users/file")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam Long id ){
		
		Users user = userService.findById(id);
		
		if(!file.isEmpty()) {
			String nameFile = file.getOriginalFilename();
			Path filePath = Paths.get("C:\\spring\\img-generics").resolve(nameFile).toAbsolutePath();
		
			try {
				Files.copy(file.getInputStream(), filePath );
			} catch (IOException e) {
				return new ResponseEntity<>("{ \"message\" : \" Error in upload File \"}"
						.concat(e.getCause().getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			user.setImg(nameFile);
			userService.save(user);
		
		}else {
			
			return new ResponseEntity<>("{ \"message\" : \"Not Change or Send Image\"}", HttpStatus.EXPECTATION_FAILED );
		
		}
		
		
		return new ResponseEntity<>("{ \"message\" : \"successfully processed file\"}", HttpStatus.CREATED );
	}
	

}
