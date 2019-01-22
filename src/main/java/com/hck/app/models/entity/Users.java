package com.hck.app.models.entity;

import java.io.Serializable;
import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
public class Users implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nick;
	private String Pass;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	/*@OneToMany(mappedBy = "users"  ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Metrics> metrics;
	
	public Users() {
		metrics = new ArrayList<Metrics>();
	}*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	/*public List<Metrics> getMetrics() {
		return metrics;
	}
	
	public void setMetrics(List<Metrics> metrics) {
		this.metrics = metrics;
	}
	
	/*public void addMetric(Metrics metrics) {
		((List<Metrics>) metrics).add(metrics);
	}*/
	
}
