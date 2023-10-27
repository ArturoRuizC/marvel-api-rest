package com.aruiz.marvelapirest.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.aruiz.marvelapirest.controller", 
		"com.aruiz.marvelapirest.servicio"})
@SpringBootApplication
public class MarvelApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApiRestApplication.class, args);
	}

}
