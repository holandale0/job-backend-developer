package br.com.concurrency.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import br.com.concurrency.model.User;
import br.com.concurrency.model.UserTest;

public interface LoginService {
	

	User authentication(String username,String password) throws InterruptedException;
	
	UserTest authenticationTest(String username,String password) throws InterruptedException;
	
	CompletableFuture<User> asyncAuthentication(String username,String password) throws InterruptedException;
	
	CompletableFuture<UserTest> asyncAuthenticationTest(String username,String password) throws InterruptedException;

}
