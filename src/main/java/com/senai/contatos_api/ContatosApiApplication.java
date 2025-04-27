package com.senai.contatos_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(title = "Contatos API",
				version = "1.0",
				description = "Coleção dos endpoints do sistema contatos",
		contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Augusto", email = "augustodemor04@gmail.com")))

@SpringBootApplication
public class ContatosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContatosApiApplication.class, args);
	}

}
