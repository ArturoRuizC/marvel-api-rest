package com.aruiz.marvelapirest.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.aruiz.marvelapi.service.MarvelAPIService;
import com.aruiz.marvelapirest.interfaces.IMarvelApiRestService;

@ComponentScan(basePackageClasses = {MarvelAPIService.class})
@Service
public class MarvelApiRestService implements IMarvelApiRestService{

	@Autowired
	MarvelAPIService coreService;

	@Override
	public Object obtieneHeroe(final int idHeroe) {
		return coreService.consultaHeroe(idHeroe);
	}

	@Override
	public Object listaHeroes() {
		return coreService.listarHeroes();
	}

}