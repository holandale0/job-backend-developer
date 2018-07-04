package br.com.concurrency;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;

import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@SpringBootApplication
//@EnableTransactionManagement
//@EnableCaching
//@EnableScheduling
//@Configuration
//@EnableAutoConfiguration
@EnableAsync
public class ConcurrencyApplication {

	public static void main(String[] args) {
		System.out.println("Teste...");
		SpringApplication.run(ConcurrencyApplication.class, args);
	}
	
	
	
    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5000); // tamanho do pool de threads a ser mantido
        executor.setMaxPoolSize(10000); // tamanho máximo do pool de threads
        executor.setQueueCapacity(500); // 
        executor.setThreadNamePrefix("LoginService-");
        executor.initialize();
        return executor;
    }
	
}
