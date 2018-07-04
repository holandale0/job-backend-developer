package br.com.concurrency.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import br.com.concurrency.dao.UserTestDAO;
import br.com.concurrency.dao.UserDAO;
import br.com.concurrency.model.User;
import br.com.concurrency.model.UserTest;


@Service
public class LoginServiceBean implements LoginService {

	@Autowired private UserDAO dao;
	
	private UserTestDAO testDao = new UserTestDAO();

    private Logger logger = LoggerFactory.getLogger(this.getClass());
     
    
    
    @Override
    public User authentication(String username, String password) throws InterruptedException {
    	
    	logger.info("service - request - authentication");
    	
    	User user = null;
    
    	user = dao.authentication(username, password); 	
    	
    	Thread.sleep(1000L);	// simulação de tempo de espera
    	
    	logger.info("service - response - authentication");
        
        return user;
      }
    
    
    
    @Override
    public UserTest authenticationTest(String username, String password) throws InterruptedException {
    	
    	logger.info("service - request - authenticationTest");
    	
    	UserTest user = null;
    
    	user = testDao.authentication(username, password); 	
    	
    	Thread.sleep(1000L);	
    	
    	logger.info("service - response - authenticationTest");
        
        return user;
      }
    
     
    
    @Override
    @Async
    public CompletableFuture<User> asyncAuthentication(String username, String password) throws InterruptedException {
    	
    	logger.info("service - request - asyncAuthentication");
    	
    	User user = null;  	
    
    	user = dao.authentication(username, password); 	
    	
    	Thread.sleep(1000L);	
    	
    	logger.info("service - response - asyncAuthentication");
    	
      return CompletableFuture.completedFuture(user);
    }
    
    
    @Override
    @Async
    public CompletableFuture<UserTest> asyncAuthenticationTest(String username, String password) throws InterruptedException {
    	
    	logger.info("service - request - asyncAuthenticationTest");
    	
    	UserTest user = null;  	
    
    	user = testDao.authentication(username, password); 		
    	
    	Thread.sleep(1000L);	
    	
    	logger.info("service - response - asyncAuthenticationTest");
    	
      return CompletableFuture.completedFuture(user);
    }

    

}
