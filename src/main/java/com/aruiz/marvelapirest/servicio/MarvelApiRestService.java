package com.aruiz.marvelapirest.servicio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aruiz.marvelapi.interfaces.IMarvelAPIService;
import com.aruiz.marvelapi.model.CharacterDataWrapper;
import com.aruiz.marvelapirest.dto.BitacoraDTO;
import com.aruiz.marvelapirest.error.MarvelApiRestException;
import com.aruiz.marvelapirest.interfaces.IMarvelApiRestService;
import com.aruiz.marvelapirest.mapper.MarvelApiRestMapper;
import com.aruiz.marvelapirest.model.Bitacora;
import com.aruiz.marvelapirest.repository.BitacoraRpository;
import com.aruiz.marvelapirest.utils.Const;

@Service
public class MarvelApiRestService implements IMarvelApiRestService{

	@Autowired
	IMarvelAPIService coreService;

	@Autowired
	private BitacoraRpository bitacoraRpository;

	@Override
	public CharacterDataWrapper obtieneHeroe(final int idHeroe) {
		CharacterDataWrapper wrapper = coreService.consultaHeroe(idHeroe);
		if (wrapper.getCode() == Const.CODE_200) {
			Bitacora bitacora = new Bitacora();
			bitacora.setHoraConsulta(LocalTime.now());
			bitacora.setUrlRequest(wrapper.getUrlRequest());
			bitacora.setStatusCode(wrapper.getCode());
			bitacora.setPath(Const.PATH_HEROE);
			bitacoraRpository.save(bitacora);
			return wrapper;
		} else {
			throw new MarvelApiRestException(Const.ERR_CON_HEROE);
		}
	}

	@Override
	public CharacterDataWrapper listaHeroes() {
		CharacterDataWrapper wrapper = coreService.listarHeroes();
		if (wrapper.getCode() == Const.CODE_200) {
			Bitacora bitacora = new Bitacora();
			bitacora.setHoraConsulta(LocalTime.now());
			bitacora.setUrlRequest(wrapper.getUrlRequest());
			bitacora.setStatusCode(wrapper.getCode());
			bitacora.setPath(Const.PATH_HEROES);
			bitacoraRpository.save(bitacora);
			return wrapper;
		} else {
			throw new MarvelApiRestException(Const.ERR_CON_HEROES);
		}
	}

	@Override
	public List<BitacoraDTO> listarBitacora() {
		List<Bitacora> ltsBitacora = bitacoraRpository.findAll();
		List<BitacoraDTO> ltsBitacoraDTO = new ArrayList<>();
		for (Bitacora bitacora : ltsBitacora) {
			ltsBitacoraDTO.add(MarvelApiRestMapper.toBitacoraDTO(bitacora));
		}
		return ltsBitacoraDTO;
	}

}