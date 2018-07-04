

Este documento se propôe a relatar os detalhes da solução do problema descrito em: 

https://github.com/intelipost/job-backend-developer


------------------------------------------------------------------------------------------------------


1 - CLONE DO REPOSITÓRIO E CONFIGURAÇÃO DO PROJETO MAVEN

	1.1 - Clone do repositório https://github.com/intelipost/job-backend-developer
	
	1.2 - Configuração do projeto Maven
	
	1.3 - Adição de dependências no pom.xml
		1.3.1 - spring-boot-starter-parent
		1.3.2 - spring-boot-starter-test
		1.3.3 - spring-boot-starter-web
		1.3.4 - spring-boot-starter-data-jpa
		1.3.5 - spring-boot-devtools
		1.3.6 - postgresql
	
	1.4 - Criação e configuração do arquivo application.properties
		1.4.1 - path: src/main/resources/application.properties
		
	1.5 - Criação dos pacotes
		1.5.1 - br.com.concurrency
		1.5.2 - br.com.concurrency.model
		1.5.3 - br.com.concurrency.dao
		1.5.4 - br.com.concurrency.service
		1.5.5 - br.com.concurrency.controller
		
	1.6 - Criação da classe principal ConcurrencyApplication.java
		1.6.1 - path: src/main/java/br/com/concurrency/ConcurrencyApplication.java
		


2 - CRIAÇÃO DAS DEMAIS CLASSES E INTERFACES DO PROJETO


Descrição: 




	2.1 - Criação da classe User.java
		2.1.1 - path: src/main/java/br/com/concurrency/model/User.java
	
	2.2 - Criação da interface UserDAO.java
		2.2.1 - path: src/main/java/br/com/concurrency/dao/UserDAO.java
	
	2.3 - Criação da interface LoginService.java
		2.3.1 - path: src/main/java/br/com/concurrency/service/LoginService.java

	
	2.4 - Criação da classe LoginServiceBean.java
		2.4.1 - path: src/main/java/br/com/concurrency/service/LoginServiceBean.java
		
	2.5 - Criação da classe LoginController.java
		2.5.1 - path: src/main/java/br/com/concurrency/controller/LoginController.java

		
	

		
		