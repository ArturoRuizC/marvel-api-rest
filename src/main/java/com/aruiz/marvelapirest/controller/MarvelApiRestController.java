package com.aruiz.marvelapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aruiz.marvelapirest.interfaces.IMarvelApiRestService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marvel")
public class MarvelApiRestController {
	
	@Autowired
	IMarvelApiRestService servicio;
	
	@GetMapping(value = "/heroes/{idHeroe}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object obtenerHeroe(final @PathVariable(value = "idHeroe") int idHeroe) {
		return servicio.obtieneHeroe(idHeroe);
	}
	
	@GetMapping(value = "/heroes", produces =  MediaType.APPLICATION_JSON_VALUE)
	public Object listarHeroes() {
		return servicio.listaHeroes();
	}
}