package br.com.concurrency.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.concurrency.model.User;

public class TestDAO {
	
	
	public User authentication(String username, String password) {
		
		User user = null;
		
		List<User> users = new ArrayList<User>();
		
		users.add(new User("jose","123"));
		users.add(new User("maria","123"));
		users.add(new User("joao","123"));
		users.add(new User("pedro","123"));
		users.add(new User("carlos","123"));
		
		for(int i = 0 ; i < users.size() ; i++) {
			
			if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
				user = users.get(i);
			}
			
		}
		
		
		
		return user;
		
	}

}
