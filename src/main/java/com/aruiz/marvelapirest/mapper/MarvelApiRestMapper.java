package com.aruiz.marvelapirest.mapper;

import java.time.format.DateTimeFormatter;
import com.aruiz.marvelapirest.dto.BitacoraDTO;
import com.aruiz.marvelapirest.model.Bitacora;
import com.aruiz.marvelapirest.utils.Const;

public class MarvelApiRestMapper {

	public static BitacoraDTO toBitacoraDTO(Bitacora bitacora) {
		BitacoraDTO dto = new BitacoraDTO();
		DateTimeFormatter  formatter = DateTimeFormatter.ofPattern(Const.FORMATO_HORA);
		dto.setHoraConsulta(bitacora.getHoraConsulta().format(formatter) + Const.HRS_LABEL);
		dto.setId(bitacora.getId());
		dto.setStatusCode(bitacora.getStatusCode());
		dto.setPath(bitacora.getPath());
		return dto;
	}
}