package br.com.concurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.concurrency.model.User;
import br.com.concurrency.model.UserTest;
import br.com.concurrency.service.LoginService;


import java.util.concurrent.CompletableFuture;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoginController {
	
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;    
    
    
    @RequestMapping(
            value = "/api/login/{username}/{password}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity authentication(@PathVariable("username") String username, @PathVariable("password") String password) throws InterruptedException {
       
    		
    		logger.info("controller - request - authentication");

        	User user = loginService.authentication(username, password);
            if (user == null) {
                return ResponseEntity.ok().body("fail");
            }

            logger.info("controller - response - authentication");
               		
    	
    	return  ResponseEntity.ok().body(user);
    	
    }
    
    
    
    @RequestMapping(
            value = "/api/loginTest/{username}/{password}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity authenticationTest(@PathVariable("username") String username, @PathVariable("password") String password) throws InterruptedException {
       
    		
    		logger.info("controller - request - authenticationTest");

    		UserTest user = loginService.authenticationTest(username, password);
            if (user == null) {
                return ResponseEntity.ok().body("fail");
            }

            logger.info("controller - response - authenticationTest");
               		
    	
    	return  ResponseEntity.ok().body(user);
    	
    }
    
    


    @RequestMapping(value = "/api/asyncLogin/{username}/{password}")
    public @ResponseBody CompletableFuture<User> asyncAuthentication(@PathVariable("username") String username, @PathVariable("password") String password) throws InterruptedException {
    	
    	logger.info("controller - request - asyncAuthentication");
    	
    	return loginService.asyncAuthentication(username, password).thenApplyAsync(user -> {
    	
    	logger.info("controller - response - asyncAuthentication");
    	
        return user;
          
        });
    	  	
      } 
    
    
    
    
    @RequestMapping(value = "/api/asyncLoginTest/{username}/{password}")
    public @ResponseBody CompletableFuture<UserTest> asyncAuthenticationTest(@PathVariable("username") String username, @PathVariable("password") String password) throws InterruptedException {
    	
    	logger.info("controller - request - asyncAuthenticationTest");
    	
    	return loginService.asyncAuthenticationTest(username, password).thenApplyAsync(user -> {
    	
    	logger.info("controller - response - asyncAuthenticationTest");
    	
        return user;
          
        });
    	  	
      } 
    

    
    
}
