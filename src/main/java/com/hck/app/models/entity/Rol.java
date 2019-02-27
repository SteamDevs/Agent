package com.hck.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="rol")
public class Rol implements Serializable {
 
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rol_name;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRol_name() {
		return rol_name;
	}

	public void setRol_name(String rol_name) {
		this.rol_name = rol_name;
	}

	
	
	
	
}
