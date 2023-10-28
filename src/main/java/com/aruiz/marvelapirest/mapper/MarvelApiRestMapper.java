package com.aruiz.marvelapirest.mapper;

import com.aruiz.marvelapirest.dto.BitacoraDTO;
import com.aruiz.marvelapirest.model.Bitacora;

public class MarvelApiRestMapper {

	public static BitacoraDTO toBitacoraDTO(Bitacora bitacora) {
		BitacoraDTO dto = new BitacoraDTO();
		dto.setFechaConsulta(bitacora.getFechaConsulta());
		dto.setId(bitacora.getId());
		dto.setStatusCode(bitacora.getStatusCode());
		dto.setPath(bitacora.getPath());
		return dto;
	}
}
