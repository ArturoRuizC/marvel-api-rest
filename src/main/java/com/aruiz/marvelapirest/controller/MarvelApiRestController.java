package com.aruiz.marvelapirest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aruiz.marvelapi.model.CharacterDataWrapper;
import com.aruiz.marvelapirest.dto.BitacoraDTO;
import com.aruiz.marvelapirest.interfaces.IMarvelApiRestService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marvel")
public class MarvelApiRestController {
	
	@Autowired
	IMarvelApiRestService servicio;
	
	@GetMapping(value = "/heroes/{idHeroe}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CharacterDataWrapper obtenerHeroe(final @PathVariable(value = "idHeroe") int idHeroe) {
		return servicio.obtieneHeroe(idHeroe);
	}

	@GetMapping(value = "/heroes", produces =  MediaType.APPLICATION_JSON_VALUE)
	public CharacterDataWrapper listarHeroes() {
		return servicio.listaHeroes();
	}
	
	@GetMapping(value = "/bitacora", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BitacoraDTO> listaBitacora() {
		return servicio.listarBitacora();
	}
}