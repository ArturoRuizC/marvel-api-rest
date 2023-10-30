package com.aruiz.marvelapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { 
		"com.aruiz.marvelapirest.controller", 
		"com.aruiz.marvelapirest.servicio",
		"com.aruiz.marvelapi",
		"com.aruiz.marvelapirest.configuracion"})
@EnableJpaRepositories(basePackages = {"com.aruiz.marvelapirest.repository"})
@EntityScan(basePackages = {"com.aruiz.marvelapirest.model"})
@SpringBootApplication
public class MarvelApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApiRestApplication.class, args);
	}
}