package br.com.concurrency;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.concurrency.model.User;
import br.com.concurrency.model.UserTest;
import br.com.concurrency.service.LoginService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final LoginService loginServiceBean;

    public AppRunner(LoginService loginServiceBean) {
        this.loginServiceBean = loginServiceBean;
    }

    @Override
    public void run(String... args) throws Exception {
    	
        
        long start = System.currentTimeMillis();
        
        List<CompletableFuture<UserTest>> lista = new ArrayList<CompletableFuture<UserTest>>();
        
        for(int i = 0 ; i < 1000 ; i++) {
        	     	

            CompletableFuture<UserTest> jose = loginServiceBean.asyncAuthenticationTest("jose","123");
            CompletableFuture<UserTest> maria = loginServiceBean.asyncAuthenticationTest("maria","123");
            CompletableFuture<UserTest> joao = loginServiceBean.asyncAuthenticationTest("joao","123");
            CompletableFuture<UserTest> pedro = loginServiceBean.asyncAuthenticationTest("pedro","123");
            CompletableFuture<UserTest> carlos = loginServiceBean.asyncAuthenticationTest("carlos","123");
                      
            
            lista.add(jose);
            lista.add(maria);
            lista.add(joao);
            lista.add(pedro);
            lista.add(carlos);              
        	
        }
        
        
        
        
        for(int i = 0 ; i < lista.size() ; i++) {
        	CompletableFuture.allOf(lista.get(i)).join();
        }
        
        
        
        
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        for(int i = 0 ; i < lista.size() ; i++) {
        	logger.info("--> " + lista.get(i).get());
        }
        



    }

}