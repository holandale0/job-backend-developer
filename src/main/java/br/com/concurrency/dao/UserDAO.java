package br.com.concurrency.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.concurrency.model.User;

public interface UserDAO extends CrudRepository<User, Long>{
	
	@Query(" select u from User u where u.username = :username and u.password = :password ")
	public User authentication(@Param("username") String username,@Param("password") String password);
	
	
}
