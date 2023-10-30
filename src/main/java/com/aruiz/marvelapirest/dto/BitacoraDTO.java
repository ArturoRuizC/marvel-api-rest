package com.aruiz.marvelapirest.dto;

import lombok.Data;

@Data
public class BitacoraDTO {

	private Integer id;
	private String horaConsulta;
	private int statusCode;
	private String path;
}