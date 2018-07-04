

Este documento se propôe a relatar os detalhes da solução do problema descrito em: 

https://github.com/intelipost/job-backend-developer


_
----------------------------------------------------------------------------------------------
INSTALAÇÃO E CONFIGURAÇÃO
----------------------------------------------------------------------------------------------


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



- A classe User.java no pacote model trata-se da representação do modelo de dados, entidade do banco de dados.

- A interface UserDAO.java é responsável por realizar as operações CRUD com o banco de dados Postgresql. Esta interface extende a interface CrudRepository, do módulo Spring Data.

- A interface LoginService.java possui algumas assinaturas de métodos que serão implementadas na classe LoginServiceBean.java

- A classe LoginServiceBean.java implementa a interface LoginService.java. Também é onde são definidas as regras de negócio para cada serviço.

- E por fim é na classe LoginController.java onde são definidos os endpoints de cada serviço definido em LoginService.java



		
3 - INSTALAÇÃO E CONFIGURAÇÃO DO POSTGRESQL


	3.1 - Instalação do Postgresql versão 10
	
	3.2 - Criação de um novo banco de dados em localhost chamado concurrency-sample
		3.2.1 - username: postgres
		3.2.2 - password: postgres
	
	3.3 - Criação da tabela user
		3.3.1 - script:
		
					CREATE TABLE public."user" (
					  id SERIAL,
					  username VARCHAR(30),
					  password VARCHAR(12),
					  CONSTRAINT user_pkey PRIMARY KEY(id)
					); 


	3.4 - Inclusão de registros na tabela user
		3.4.1 - script: 
		
					INSERT INTO public."user"(username, password) VALUES ('joao','123');
					
					INSERT INTO public."user"(username, password) VALUES ('jose','123');
					
					INSERT INTO public."user"(username, password) VALUES ('maria','123');
					
					INSERT INTO public."user"(username, password) VALUES ('pedro','123');
					
					INSERT INTO public."user"(username, password) VALUES ('carlos','123');
		
	3.5 - Criação da classe LoginController.java
		2.5.1 - path: src/main/java/br/com/concurrency/controller/LoginController.java
	


_
----------------------------------------------------------------------------------------------
TESTES
----------------------------------------------------------------------------------------------
		

1 - Teste automático de 5000 requisições

	Para a simulação de um teste de 5000 requisições, foram criadas as seguintes classes:
	
	- UserTest.java no pacote model
	- UserTestDAO.java no pacote dao
	- AppRunner.java no pacote raiz (br.com.concurrency)
	
	Então, assim que a aplicação é iniciada, este teste é realizado e a sua execução pode ser acompanhada através dos logs no console.é



2 - Teste dos serviço

	Para realizar o teste dos serviços, basta iniciar a aplicação e acessar as URLs listadas abaixo no browser do navegador ou em algum software de teste de serviços (Postman, SoupUI)s

	2.1 - Autenticação síncrona:
		2.1.1 - endpoint: http://localhost:8080/api/login/maria/123
		
	2.2 - Autenticação assíncrona:
		2.2.1 - endpoint: http://localhost:8080/api/asyncLogin/joao/123 
	2.3 - Autenticação síncrona mock:
		2.3.1 - endpoint: http://localhost:8080/api/loginTest/pedro/123
		
	2.4 - Autenticação assíncrona mock:
		2.4.1 - endpoint: http://localhost:8080/api/asyncLoginTest/carlos/123



_
----------------------------------------------------------------------------------------------
CONCLUSÃO
----------------------------------------------------------------------------------------------
	
A solução para o problema descrito em https://github.com/intelipost/job-backend-developer se deu através da utilização do recurso Async do Spring.

Na classe principal do projeto(ConcurrencyApplication.java), foi incluída a anotação @EnableAsync, onde o próprio nome sugere, habilita o uso de chamadas assíncronas.

Ainda na classe principal, foi criado um Bean chamado asyncExecutor, onde são definidas algumas regras para tratamento de chamadas assíncronas, como por exemplo o limite de threads simultâneas.

A classe AppRunner.java foi criada com o objetivo de realizar um teste automático de 5000 requisições. Ela implementa a interface CommandLineRunner.  

















