package br.com.concurrency.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.concurrency.model.User;
import br.com.concurrency.model.UserTest;

public class UserTestDAO {
	
	
	public UserTest authentication(String username, String password) {
		
		UserTest user = null;
		
		List<UserTest> users = new ArrayList<UserTest>();
		
		users.add(new UserTest("jose","123"));
		users.add(new UserTest("maria","123"));
		users.add(new UserTest("joao","123"));
		users.add(new UserTest("pedro","123"));
		users.add(new UserTest("carlos","123"));
		
		for(int i = 0 ; i < users.size() ; i++) {
			
			if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
				user = users.get(i);
			}
			
		}
		
		
		
		return user;
		
	}

}
