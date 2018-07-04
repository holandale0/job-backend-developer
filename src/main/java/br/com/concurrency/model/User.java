package br.com.concurrency.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="user_id_seq")
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq", allocationSize=1)
	Long id;	
	@Column String username;
	@Column String password;
	
	
	
	public User() {
		
	}


	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	
	

}
