package com.hck.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "emmiters" )
public class Emmiters implements Serializable {

	/**
	 *    
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	private String context;
	private String priority;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	//[Obs] Add Owner who issues
	
	
	
}
