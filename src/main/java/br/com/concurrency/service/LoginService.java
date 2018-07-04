package br.com.concurrency.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import br.com.concurrency.model.User;

public interface LoginService {
	

	User authentication(String username,String password) throws InterruptedException;
	
	User authenticationTest(String username,String password) throws InterruptedException;
	
	CompletableFuture<User> asyncAuthentication(String username,String password) throws InterruptedException;
	
	CompletableFuture<User> asyncAuthenticationTest(String username,String password) throws InterruptedException;

}
