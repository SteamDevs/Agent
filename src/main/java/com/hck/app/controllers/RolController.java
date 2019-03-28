package com.hck.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hck.app.models.entity.Rol;
import com.hck.app.models.services.RServiceImpl;

@RestController
@RequestMapping("api/v1")
public class RolController {

	@Autowired
	private RServiceImpl rolService;
	
	@PostMapping("/rol")
	public ResponseEntity<?> storedRol(@RequestBody Rol rol ){
		
		Rol newRol = null;
		
		try {
			
			newRol = rolService.save(rol);
			
		}catch(DataAccessException e ) {
			
			return new ResponseEntity<>("{ \"message\" : \"DB Errors\"}"
					.concat(e.getMostSpecificCause().getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Rol>(newRol, HttpStatus.CREATED ); 
	}
	
}
