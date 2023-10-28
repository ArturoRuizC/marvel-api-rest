package com.aruiz.marvelapirest.interfaces;

import java.util.List;
import com.aruiz.marvelapi.model.CharacterDataWrapper;
import com.aruiz.marvelapirest.dto.BitacoraDTO;

public interface IMarvelApiRestService {

	CharacterDataWrapper obtieneHeroe(int idHeroe);

	CharacterDataWrapper listaHeroes();
	
	List<BitacoraDTO> listarBitacora();
}